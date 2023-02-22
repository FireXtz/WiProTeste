package org.example.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ResponseExceptionHandler {
    public static ResponseEntity<Object> errorResponseNotFound(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("mensagem", message);
        map.put("status", status.value());
        return new ResponseEntity<Object>(map,status);
    }





}
