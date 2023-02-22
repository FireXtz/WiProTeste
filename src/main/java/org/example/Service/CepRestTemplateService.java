package org.example.Service;

import org.example.Request.CepRequest;
import org.example.Response.CepResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class CepRestTemplateService {
    public ResponseEntity<CepResponse> pesquisar( CepRequest cepRequest) {
        RestTemplate restTemplate = new RestTemplate();
        String uriBuilder = "http://viacep.com.br/ws/"+cepRequest.getCep()+"/json/";
        CepResponse cepResponse = restTemplate.getForObject(uriBuilder,CepResponse.class);
        return new ResponseEntity<CepResponse>(cepResponse, HttpStatus.OK);
    }
}
