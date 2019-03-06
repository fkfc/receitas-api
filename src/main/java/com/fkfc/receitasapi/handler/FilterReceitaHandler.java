package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Camada de abstração entre o controlador REST e o repositório de receitas.
 */
@Component
public class FilterReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    /**
     * Recupera no repositório uma lista de receitas que satisfazem o filtro fornecido
     * @param filter Filtro de busca
     * @return Lista de instâncias de Receitas.
     */
    public List<Receita> handleGetReceita(ReceitaFilter filter) {
        return receitaRepository.getByFilter(filter);
    }

}
