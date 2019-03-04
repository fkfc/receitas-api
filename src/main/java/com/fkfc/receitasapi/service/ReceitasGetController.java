package com.fkfc.receitasapi.service;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ReceitasGetController {

    @CrossOrigin
    @RequestMapping("/")
    public String root() {
        return "REST controller is running";
    }

    @CrossOrigin
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public String getReceita(
            @RequestParam(value = "nome") String nome,
            @RequestParam(value = "categorias", required = false) List<String> categorias,
            @RequestParam(value = "ingredientes", required = false) List<String> ingredientes
    ) {
        System.out.println(nome);
        return "GET receita";
    }


}
