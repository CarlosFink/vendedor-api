package br.com.fink.vendedorapi.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fink.vendedorapi.payload.VendedorRequest;
import br.com.fink.vendedorapi.payload.VendedorResponse;
import br.com.fink.vendedorapi.services.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public ResponseEntity<List<VendedorResponse>> listAll() {		
		return ResponseEntity.ok().body(vendedorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VendedorResponse> findById(@PathVariable Integer id) {
		VendedorResponse vendedor = vendedorService.findById(id);
		return ResponseEntity.ok().body(vendedor);
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<VendedorResponse> findByMatricula(@PathVariable String matricula) {
		VendedorResponse vendedor = vendedorService.findByMatricula(matricula);
		return ResponseEntity.ok().body(vendedor);
	}
	
	@PostMapping
	public ResponseEntity<VendedorResponse> create(@Valid @RequestBody VendedorRequest vendedorRequest) {
		VendedorResponse vendedor = vendedorService.create(vendedorRequest);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(vendedor.getId())
				.toUri();
		return ResponseEntity.created(uri).body(vendedor);
	}
	
	@PutMapping
	public ResponseEntity<VendedorResponse> update(@Valid @RequestBody VendedorRequest vendedorRequest) {
		VendedorResponse vendedor = vendedorService.update(vendedorRequest);
		return ResponseEntity.ok().body(vendedor);
	}
}
