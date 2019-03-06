package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Camada de abstração entre o controlador REST e o repositório de receitas.
 */
@Component
public class GetReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    public GetReceitaHandler(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    /**
     * Recupera no repositório uma receita especificada pelo número de ID
      * @param id Número identificador da receita a ser recuperada
     * @return Instância da Receita
     */
    public Receita handleGetReceitaById(Integer id) {
        return receitaRepository.getById(id);
    }

}
