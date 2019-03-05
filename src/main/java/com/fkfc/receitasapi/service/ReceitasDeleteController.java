package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.DeleteReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceitasDeleteController {

    @Autowired
    DeleteReceitaHandler deleteReceitaHandler;

    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    public String getReceitaById(@PathVariable("id") Integer receitaId) {
        return deleteReceitaHandler.handleDeleteReceita(receitaId);
    }

}
