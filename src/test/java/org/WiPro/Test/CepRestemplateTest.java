package org.WiPro.Test;

import lombok.extern.slf4j.Slf4j;
import org.WiPro.Request.CepRequest;
import org.WiPro.Response.CepResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class CepRestemplateTest {
    @LocalServerPort
    int serverPort;
    @Test
    public void test_pesquisar_cep () throws URISyntaxException{

        CepRequest cepRequest = new CepRequest();
        cepRequest.setCep("01001000");

        RestTemplate restTemplate = new RestTemplate();

        String ViaCepURL = "http://viacep.com.br/ws/"+cepRequest.getCep()+"/json/";
        URI uriViaCep = new URI(ViaCepURL);
        ResponseEntity<CepResponse> result = restTemplate.getForEntity(String.valueOf(uriViaCep), CepResponse.class);
        System.out.println("########### TESTE DE UNIDADE###########");
        System.out.println("cep:"+ result.getBody().getCep());
        System.out.println("rua:"+ result.getBody().getLogradouro());
        System.out.println("complemento:"+ result.getBody().getComplemento());
        System.out.println("bairro:"+ result.getBody().getBairro());
        System.out.println("cidade:"+ result.getBody().getLocalidade());
        System.out.println("estado:"+ result.getBody().getUf());
        System.out.println("frete:"+ result.getBody().calcularFrete());



    }



}
