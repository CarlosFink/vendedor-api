package br.com.fink.vendedorapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fink.vendedorapi.clients.FilialClient;
import br.com.fink.vendedorapi.models.Vendedor;
import br.com.fink.vendedorapi.payload.VendedorRequest;
import br.com.fink.vendedorapi.payload.VendedorResponse;
import br.com.fink.vendedorapi.repositories.VendedorRepository;
import br.com.fink.vendedorapi.services.exceptions.DocumentDuplicateException;
import br.com.fink.vendedorapi.services.exceptions.DocumentNotFoundException;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;

	@Autowired
	private FilialClient filialClient;

	@Autowired
	private ModelMapper modelMapper;

	public List<VendedorResponse> findAll() {
		List<Vendedor> vendedores = vendedorRepository.findAll();
		List<VendedorResponse> response = new ArrayList<>();
		vendedores.forEach(vendedor -> response.add(convertToResponse(vendedor)));
		return response;
	}

	public VendedorResponse findById(String id) {
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		if (!vendedor.isPresent()) {
			throw new DocumentNotFoundException("Documento com id:" + id + " não encontrado");
		}
		return convertToResponse(vendedor.get());
	}

	public VendedorResponse findByMatricula(String matricula) {
		Optional<Vendedor> vendedor = vendedorRepository.findByMatricula(matricula);
		if (!vendedor.isPresent()) {
			throw new DocumentNotFoundException("Documento com matrícula:" + matricula + " não encontrado");
		}
		return convertToResponse(vendedor.get());
	}

	public VendedorResponse create(VendedorRequest vendedorRequest) {
		if (vendedorRepository.findByMatricula(vendedorRequest.getMatricula()).isPresent()) {
			throw new DocumentDuplicateException(
					"Documento com matrícula:" + vendedorRequest.getMatricula() + " já existente");
		}
		Vendedor vendedor = new Vendedor();
		vendedor.setMatricula(vendedorRequest.getMatricula());
		vendedor.setNome(vendedorRequest.getNome());
		vendedor.setDataNasc(vendedorRequest.getDataNasc());
		vendedor.setFilial(filialClient.getFilial(vendedorRequest.getFilialId()));
		vendedor = vendedorRepository.save(vendedor);
		return convertToResponse(vendedor);
	}

	public VendedorResponse update(VendedorRequest vendedorRequest) {
		Vendedor vendedor = convertToVendedor(findByMatricula(vendedorRequest.getMatricula()));
		vendedor.setMatricula(vendedorRequest.getMatricula());
		vendedor.setNome(vendedorRequest.getNome());
		vendedor.setDataNasc(vendedorRequest.getDataNasc());
		vendedor.setFilial(filialClient.getFilial(vendedorRequest.getFilialId()));
		vendedor = vendedorRepository.save(vendedor);
		return convertToResponse(vendedor);
	}

	private VendedorResponse convertToResponse(Vendedor vendedor) {
		return modelMapper.map(vendedor, VendedorResponse.class);
	}

	private Vendedor convertToVendedor(VendedorResponse vendedorResponse) {
		return modelMapper.map(vendedorResponse, Vendedor.class);
	}
}
