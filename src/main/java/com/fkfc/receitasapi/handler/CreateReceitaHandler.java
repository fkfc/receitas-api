package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Camada de abstração entre o controlador REST e o repositório de receitas.
 */
@Component
public class CreateReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    public CreateReceitaHandler(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    /**
     * Informa o repositório para cadastrar uma nova receita
     * @param receita DTO da nova receita
     * @return String "OK", quando a inserção for bem sucedida
     */
    public String handleCreateReceita(Receita receita) {
        receitaRepository.saveReceita(receita);
        return "OK";
    }

}
