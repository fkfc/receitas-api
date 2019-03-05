package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    public Receita handlePatchReceita(Receita partialReceita, Integer receitaId) {
        System.out.println("updating receita partial " + partialReceita.toString());
        receitaRepository.patchReceita(partialReceita, receitaId);
        return receitaRepository.getById(receitaId);
    }

    public Receita handlePutReceita(Receita receita, Integer receitaId) {
        receitaRepository.putReceita(receita, receitaId);
        return receitaRepository.getById(receitaId);
    }

}
