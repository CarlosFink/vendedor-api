package br.com.fink.vendedorapi.payload;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import br.com.fink.vendedorapi.models.Filial;

public class VendedorResponse {

	@Field("id")
	private String id;	
	
	@Field("document_id")
	private Integer documentId;
	
	@Field("matricula")
	private String matricula;
	
	@Field("nome")
	private String nome;
	
	@Field("data_nascimento")
	private Date dataNascimento;
	
	@Field("filial")
	private Filial filial;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}	
}
