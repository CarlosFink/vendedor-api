package br.com.fink.vendedorapi.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.fink.vendedorapi.models.Filial;
import br.com.fink.vendedorapi.services.exceptions.DocumentNotFoundException;

@Component
public class FilialClient {

	public Filial getFilial(Integer id) {
		String baseUrl = "http://filial-api:8080/filiais/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Filial> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Filial.class, id);
		} catch (HttpClientErrorException e) {
			if (e.getRawStatusCode() == 404) {
				throw new DocumentNotFoundException("Filial " + id + " não encontrada");
			}
		} 
		if (response != null) {
			return response.getBody();
		} else {
			return null;
		}
	}

	private static HttpEntity<Void> getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
