package org.WiPro.Controller;

import org.WiPro.Request.CepRequest;
import org.WiPro.Response.CepResponse;
import org.WiPro.Response.ResponseExceptionHandler;
import org.WiPro.Service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("v2/consulta-endereco")
public class CepFeignController {
    @Autowired
    private CepService cepService;

    @PostMapping
    public ResponseEntity<Object> pesquisarCep(@RequestBody CepRequest cepRequest) {
        try {
            CepResponse cepResponse = cepService.doExecute(cepRequest);
            return ResponseEntity.ok().body(cepResponse);

        } catch (Exception e) {
            return ResponseExceptionHandler.errorResponseNotFound("Não foi possivel encontrar o cep indicado:" + cepRequest.getCep(), HttpStatus.NOT_FOUND);
        }
    }

}
