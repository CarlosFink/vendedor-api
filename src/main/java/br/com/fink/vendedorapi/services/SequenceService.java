package br.com.fink.vendedorapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fink.vendedorapi.models.DatabaseSequence;
import br.com.fink.vendedorapi.repositories.SequenceRepository;

@Service
public class SequenceService {

	private static final String SEQUENCE_NAME = "vendedor_sequence";

	@Autowired
	private SequenceRepository sequenceRepository;

	public Optional<DatabaseSequence> findbyId(String id) {
		return sequenceRepository.findById(id);
	}

	public Integer generateSequence() {
		Optional<DatabaseSequence> sequence = this.findbyId(SEQUENCE_NAME);
		if (!sequence.isPresent()) {
			DatabaseSequence newSequence = new DatabaseSequence();
			newSequence.setId(SEQUENCE_NAME);
			newSequence.setSeqNo(1);
			sequenceRepository.save(newSequence);
			return 1;
		} else {
			sequence.get().setSeqNo(sequence.get().getSeqNo() + 1);
			DatabaseSequence newSequence = sequenceRepository.save(sequence.get());
			return newSequence.getSeqNo();
		}
	}
}
