package br.com.fink.runners;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class StepDefinitions {
	
	private final String BASE_URI = "http://localhost:8888";	
	RequestSpecification request;
	Response response;
	
	@Dado("^que tenho uma chamada valida$")
	public void que_tenho_uma_chamada_valida() throws Throwable {
		RestAssured.baseURI = BASE_URI;
		request = RestAssured.given();
	}

	@Quando("^pesquisar$")
	public void pesquisar() throws Throwable {
		response = request.get("/vendedores");		
	}

	@Então("^retorna uma lista de vendedores$")
	public void retorna_uma_lista_de_vendedores() throws Throwable {
		System.out.println(response.asPrettyString());	
		response.then().statusCode(200);
	}
	
	@Dado("que tenho o documento id {int}")
	public void que_tenho_o_documento_id(Integer documentId) {
		RestAssured.baseURI = BASE_URI;
		RestAssured.basePath = "/vendedores/" + documentId;
		request = RestAssured.given();
	}

	@Quando("pesquisar vendedor por documento")
	public void pesquisar_vendedor_por_documento() {
		response = request.get();	
	}
	
	@Então("retorna dados do vendedor por documento")
	public void retorna_dados_do_vendedor_por_documento() {
		System.out.println(response.asPrettyString());
		response.then().statusCode(200).assertThat().body("matricula", equalTo("4905092523"));
	}
	
	@Dado("que tenho a matricula {string} do vendedor")
	public void que_tenho_a_matricula_do_vendedor(String matricula) {
		RestAssured.baseURI = BASE_URI;
		RestAssured.basePath = "/vendedores/matricula/" + matricula;
		request = RestAssured.given();
	}

	@Quando("pesquisar vendedor por matricula")
	public void pesquisar_vendedor_por_matricula() {
		response = request.get();	
	}

	@Então("retorna dados do vendedor por matricula")
	public void retorna_dados_do_vendedor_por_matricula() {
		System.out.println(response.asPrettyString());
		response.then().statusCode(200).assertThat().body("documentId", equalTo(1));
	}
	
	@Dado("que tenho os dados do vendedor")
	public void que_tenho_os_dados_do_vendedor(DataTable dados) {
		RestAssured.baseURI = BASE_URI;
		RestAssured.basePath = "/vendedores";
		
		JSONObject requestPayload = new JSONObject();
		
		List<Map<String, String>> vendedores = dados.asMaps(String.class, String.class);
		for (Map<String, String> vendedor : vendedores) {
			requestPayload.put("matricula", vendedor.get("matricula"));
			requestPayload.put("nome", vendedor.get("nome"));
			requestPayload.put("dataNascimento", vendedor.get("dataNascimento"));
			requestPayload.put("filialId", vendedor.get("filial"));
			request = RestAssured.given();
			request.headers("Content-Type", "application/json");
			request.body(requestPayload.toString());
		}		
	}

	@Quando("solicitar inclusão do vendedor")
	public void solicitar_inclusão_do_vendedor() {
		response = request.post();
	}

	@Então("retorna dados do vendedor incluido")
	public void retorna_dados_do_vendedor_incluido() {
		System.out.println(response.asPrettyString());
		response.then().statusCode(201).assertThat().body("matricula", equalTo("4905092532"));
	}
	
	@Dado("que tenho os dados de alteração do vendedor")
	public void que_tenho_os_dados_de_alteração_do_vendedor(DataTable dados) {
		RestAssured.baseURI = BASE_URI;
		RestAssured.basePath = "/vendedores";
		
		JSONObject requestPayload = new JSONObject();
		
		List<Map<String, String>> vendedores = dados.asMaps(String.class, String.class);
		for (Map<String, String> vendedor : vendedores) {
			requestPayload.put("matricula", vendedor.get("matricula"));
			requestPayload.put("nome", vendedor.get("nome"));
			requestPayload.put("dataNascimento", vendedor.get("dataNascimento"));
			requestPayload.put("filialId", vendedor.get("filial"));
			request = RestAssured.given();
			request.headers("Content-Type", "application/json");
			request.body(requestPayload.toString());
		}		
	}

	@Quando("solicitar alteração do vendedor")
	public void solicitar_alteração_do_vendedor() {
		response = request.put();
	}

	@Então("retorna dados do vendedor alterado")
	public void retorna_dados_do_vendedor_alterado() {
		System.out.println(response.asPrettyString());
		response.then().statusCode(200).assertThat().body("matricula", equalTo("4905092530"));
	}
}
