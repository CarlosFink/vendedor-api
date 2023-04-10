package br.com.fink.vendedorapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fink.vendedorapi.models.DatabaseSequence;

public interface SequenceRepository extends MongoRepository<DatabaseSequence, String> {

}
