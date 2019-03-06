package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Camada de abstração entre o controlador REST e o repositório de receitas.
 */
@Component
public class DeleteReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    /**
     * Informa o repositório para excluir uma receita
     * @param receitaId ID da receita a ser excluída
     * @return String "OK" se a exclusão for bem sucedida
     */
    public String handleDeleteReceita(Integer receitaId) {
        receitaRepository.deleteReceita(receitaId);
        return "OK";
    }
}
