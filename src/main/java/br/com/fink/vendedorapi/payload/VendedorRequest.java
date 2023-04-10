package br.com.fink.vendedorapi.payload;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VendedorRequest {
	
	@NotEmpty
	private String matricula;
	
	@NotEmpty
	private String nome;
	
	private Date dataNascimento;
	
	@NotNull
	private Integer filialId;
	
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

	public Integer getFilialId() {
		return filialId;
	}

	public void setFilialId(Integer filialId) {
		this.filialId = filialId;
	}	
}
