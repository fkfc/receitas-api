package com.fkfc.receitasapi.service;

import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.handler.UpdateReceitaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador com os métodos PUT
 */
@RestController
public class ReceitasPutController {

    @Autowired
    UpdateReceitaHandler updateReceitaHandler;

    /**
     * Atualiza toda uma receita especificada pelo ID
     * @param receita Novos dados da receita
     * @param receitaId Número identificador da receita
     * @return Nova instância da receita
     */
    @PutMapping("/put/{id}")
    public Receita putReceita(
            @RequestBody Receita receita, @PathVariable("id") Integer receitaId
    ) {
        return updateReceitaHandler.handlePutReceita(receita, receitaId);
    }
}
