package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import com.fkfc.receitasapi.handler.FilterReceitaHandler;
import com.fkfc.receitasapi.handler.GetReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ReceitasGetController {

    @Autowired
    FilterReceitaHandler filterReceitaHandler;

    @Autowired
    GetReceitaHandler getReceitaHandler;


    @CrossOrigin
    @RequestMapping("/")
    public String root() {
        return "REST controller is running";
    }

    @CrossOrigin
    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET})
    public Receita getReceitaById(@PathVariable("id") Integer id) {
        return getReceitaHandler.getReceitaById(id);
    }


    @CrossOrigin
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public List<Receita> getReceita(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "categorias", required = false) List<String> categorias,
            @RequestParam(value = "ingredientes", required = false) List<String> ingredientes
    ) {
        ReceitaFilter filter = new ReceitaFilter(nome, ingredientes, categorias);
        return filterReceitaHandler.handleGetReceita(filter);
    }


}
