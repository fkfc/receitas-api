package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    public Receita getReceitaById(Integer id) {
        return receitaRepository.getById(id);
    }

}
