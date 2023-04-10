package br.com.fink.vendedorapi.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class Filial {
	
	@Field("id")
	private Integer id;    
    private String nome;    
    private String cnpj;
    private String cidade;    
    private String uf;    
    private ETipo tipo;    
    private Boolean ativo;
    @Field("data_cadastro")
    private Date dataCadastro;
    @Field("ultima_atualizacao")
    private Date ultimaAtualizacao;
    @Field("cnpj_editado")
    private String cnpjEditado;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public ETipo getTipo() {
		return tipo;
	}
	public void setTipo(ETipo tipo) {
		this.tipo = tipo;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
	public String getCnpjEditado() {
		return cnpjEditado;
	}
	public void setCnpjEditado(String cnpjEditado) {
		this.cnpjEditado = cnpjEditado;
	} 
}
