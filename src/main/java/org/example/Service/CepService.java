package org.example.Service;

import org.example.Feign.CepFeign;
import org.example.Request.CepRequest;
import org.example.Response.CepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
    @Autowired
    private CepFeign cepFeign;
    public CepResponse doExecute(CepRequest cepRequest){
        return this.cepFeign.pesquisarPorCep(cepRequest.getCep());
    }

}
