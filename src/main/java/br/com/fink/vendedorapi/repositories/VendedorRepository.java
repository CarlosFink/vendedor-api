package br.com.fink.vendedorapi.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fink.vendedorapi.models.Vendedor;

public interface VendedorRepository extends MongoRepository<Vendedor, String> {
	
	Optional<Vendedor> findByMatricula(String matricula);

	Optional<Vendedor> findByDocumentId(Integer id);
}
