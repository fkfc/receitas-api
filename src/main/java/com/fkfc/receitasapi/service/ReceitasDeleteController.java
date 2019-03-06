package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.handler.DeleteReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador com os métodos DELETE
 */
@RestController
public class ReceitasDeleteController {

    @Autowired
    DeleteReceitaHandler deleteReceitaHandler;

    /**
     * Exclui uma receita identificada pelo ID
     * @param receitaId ID da receita a ser excluída
     * @return String "OK" se a exclusão for bem sucedida
     */
    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    public String deleteReceitaById(@PathVariable("id") Integer receitaId) {
        return deleteReceitaHandler.handleDeleteReceita(receitaId);
    }

}
