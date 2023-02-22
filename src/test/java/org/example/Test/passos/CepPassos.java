package org.example.Test.passos;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.example.Response.CepResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class CepPassos {
    private String url;
    private String baseUrl = "http://viacep.com.br/ws";
    private Response response;
    private List<CepResponse> cepResponseList = new ArrayList<CepResponse>();

    public CepPassos() {
        gerarMassa();
    }

    @Given("^o usuario insere um \"([^\"]*)\"$")
    public void oUsuarioInsereUm(String cep) throws Throwable {
        url = gerarUrl(cep);
    }

    @When("^o servico eh consultado$")
    public void oServicoEhConsultado() throws Throwable {
        response = get(url);
    }

    @Then("^eh retornado o \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void ehRetornadoO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge) throws Throwable {
        response.then().statusCode(200);
        response.then().body("cep", is(cep));
        response.then().body("logradouro", is(logradouro));
        response.then().body("complemento", is(complemento));
        response.then().body("bairro", is(bairro));
        response.then().body("localidade", is(localidade));
        response.then().body("uf", is(uf));
        response.then().body("ibge", is(ibge));
    }

    @Then("^eh retornada um atributo \"([^\"]*)\"$")
    public void ehRetornadaUmAtributo(Boolean erro) throws Throwable {
        response.then().statusCode(200);
        response.then().body("erro", is(erro));
    }

    @Then("^eh retornada um \"([^\"]*)\"$")
    public void ehRetornadaUma(Boolean erro) throws Throwable {
        response.then().statusCode(400);
        response.then().body("erro", is(erro));
    }

    @Given("^o usuario insere \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void oUsuarioInsere(String uf, String localidade, String logradouro) throws Throwable {
        url = gerarUrl(uf, localidade, logradouro);
    }

    @Then("^eh retornada uma lista de locais que correspondem a pesquisa$")
    public void ehRetornadaUmaListaDeLocaisQueCorrespondemAPesquisa() throws Throwable {
        response.then().statusCode(200);
        response.then().body("$", hasSize(cepResponseList.size()));
        for (int i = 0; i < cepResponseList.size(); i++) {
            response.then().body("cep["+i+"]", is(cepResponseList.get(i).getCep()));
            response.then().body("logradouro["+i+"]", is(cepResponseList.get(i).getLogradouro()));
            response.then().body("complemento["+i+"]", is(cepResponseList.get(i).getComplemento()));
            response.then().body("bairro["+i+"]", is(cepResponseList.get(i).getBairro()));
            response.then().body("localidade["+i+"]", is(cepResponseList.get(i).getLocalidade()));
            response.then().body("uf["+i+"]", is(cepResponseList.get(i).getUf()));
        }
    }

    private String gerarUrl(String cep) {
        return baseUrl + "/" + cep + "/json/";
    }

    private String gerarUrl(String uf, String localidade, String logradouro) {
        return baseUrl + "/" + uf + "/" + localidade + "/" + logradouro + "/json/";
    }

    private void gerarMassa() {
        cepResponseList.add(new CepResponse("94085-170", "Rua Ari Barroso", "", "Morada do Vale I", "Gravataí", "RS", BigDecimal.valueOf(17.30)));
        cepResponseList.add(new CepResponse("94175-000", "Rua Almirante Barroso", "", "Recanto Corcunda", "Gravataí", "RS", BigDecimal.valueOf(17.30)));
    }



}
