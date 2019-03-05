package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.UpdateReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceitasPutController {

    @Autowired
    UpdateReceitaHandler updateReceitaHandler;

    @PutMapping("/put/{id}")
    public Receita putReceita(
            @RequestBody Receita receita, @PathVariable("id") Integer receitaId
    ) {
        return updateReceitaHandler.handlePutReceita(receita, receitaId);
    }
}
