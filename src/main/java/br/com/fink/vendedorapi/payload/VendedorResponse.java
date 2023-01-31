package br.com.fink.vendedorapi.payload;

import java.util.Date;

import br.com.fink.vendedorapi.models.Filial;

public class VendedorResponse {

	private String id;	
	
	private String matricula;
	
	private String nome;
	
	private Date dataNasc;
	
	private Filial filial;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}	
}
