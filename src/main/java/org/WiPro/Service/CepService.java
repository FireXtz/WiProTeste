package org.WiPro.Service;

import org.WiPro.Feign.CepFeign;
import org.WiPro.Request.CepRequest;
import org.WiPro.Response.CepResponse;
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
