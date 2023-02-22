package org.WiPro.Feign;

import org.WiPro.Response.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/",name = "viacepClient")
public interface CepFeign {
    @GetMapping(value = "{cep}/json")
    CepResponse pesquisarPorCep(@PathVariable("cep") String cep);
}
