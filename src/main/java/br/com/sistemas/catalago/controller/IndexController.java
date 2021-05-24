package br.com.sistemas.catalago.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index(){
        return "servidor inicializado";
    }
}
