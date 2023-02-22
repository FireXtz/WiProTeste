package org.WiPro.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
public class CepResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private BigDecimal frete;

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    @JsonProperty("complemento")
    public String getComplemento() {
        return complemento;
    }
    @JsonProperty("complemento")
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @JsonProperty("rua")
    public String getLogradouro() {
        return logradouro;
    }
    @JsonProperty("logradouro")
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    @JsonProperty("bairro")
    public String getBairro() {
        return bairro;
    }
    @JsonProperty("bairro")
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    @JsonProperty("cidade")
    public String getLocalidade() {
        return localidade;
    }
    @JsonProperty("localidade")
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    @JsonProperty("estado")
    public String getUf() {
        return uf;
    }
    @JsonProperty("uf")
    public void setUf(String uf) {
        this.uf = uf;
    }
    @JsonProperty("frete")
    public BigDecimal calcularFrete() {
        if (this.uf.equals("SP")|| this.uf.equals("RJ")||this.uf.equals("ES")||this.uf.equals("MG")){
            frete = BigDecimal.valueOf(7.85);
        }
        if (this.uf.equals("GO")|| this.uf.equals("MT")||this.uf.equals("MS")|| this.uf.equals("DF")){
            frete = BigDecimal.valueOf(12.50);
        }
        if (this.uf.equals("MA")||this.uf.equals("PI")||this.uf.equals("CE")
                ||this.uf.equals("RN")||this.uf.equals("PB")||this.uf.equals("PE")||this.uf.equals("AL")
                ||this.uf.equals("SE")||this.uf.equals("BA")){
            frete = BigDecimal.valueOf(15.98);
        }
        if (this.uf.equals("PR")|| this.uf.equals("SC")||this.uf.equals("RS")){
            frete = BigDecimal.valueOf(17.30);
        }

        if (this.uf.equals("AC")|| this.uf.equals("AP")
                ||this.uf.equals("PA")||this.uf.equals("RO")||this.uf.equals("RR")||this.uf.equals("TO") ){
            frete = BigDecimal.valueOf(20.83);
        }
        return frete;
    }
    @JsonProperty("frete")
    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }
}
