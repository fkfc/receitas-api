package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    public String handleDeleteReceita(Integer receitaId) {
        receitaRepository.deleteReceita(receitaId);
        return "OK";
    }
}
