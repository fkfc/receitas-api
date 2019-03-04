package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.CreateReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceitasPostController {

    @Autowired
    CreateReceitaHandler createReceitaHandler;

    @CrossOrigin
    @RequestMapping(value = "/post", method = {RequestMethod.POST})
    public String postReceita(
            @RequestBody Receita receita
    ) {
        return createReceitaHandler.handleCreateReceita(receita);
    }

}
