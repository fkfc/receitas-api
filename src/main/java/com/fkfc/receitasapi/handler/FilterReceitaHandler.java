package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    public List<Receita> handleGetReceita(ReceitaFilter filter) {
        return receitaRepository.getByFilter(filter);
    }

}
