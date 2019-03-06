package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.UpdateReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador com os métodos PATCH
 */
@RestController
public class ReceitasPatchController {

    @Autowired
    UpdateReceitaHandler updateReceitaHandler;

    /**
     * Altera os campos desejados de uma receita
     * @param partialReceita Especificação da receita, cujos campos preenchidos serão os campos alterados
     * @param receitaId ID da receita a ser alterada
     * @return Nova instância da receita, com os campos alterados.
     */
    @PatchMapping("/patch/{id}")
    public Receita updateReceita(
            @RequestBody Receita partialReceita, @PathVariable("id") Integer receitaId
    ) {
        return updateReceitaHandler.handlePatchReceita(partialReceita, receitaId);
    }

}
