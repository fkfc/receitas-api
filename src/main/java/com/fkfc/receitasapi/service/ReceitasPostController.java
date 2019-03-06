package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.CreateReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador com os métodos POST
 */
@RestController
public class ReceitasPostController {

    @Autowired
    CreateReceitaHandler createReceitaHandler;

    public ReceitasPostController(CreateReceitaHandler createReceitaHandler) {
        this.createReceitaHandler = createReceitaHandler;
    }

    /**
     * Cadastra uma nova receita
     * @param receita Dados da nova receita
     * @return String "OK", se a inserção for bem sucedida
     */
    @CrossOrigin
    @RequestMapping(value = "/post", method = {RequestMethod.POST})
    public String postReceita(
            @RequestBody Receita receita
    ) {
        return createReceitaHandler.handleCreateReceita(receita);
    }

}
