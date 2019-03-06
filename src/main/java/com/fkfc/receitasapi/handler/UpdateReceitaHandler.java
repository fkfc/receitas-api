package com.fkfc.receitasapi.handler;

import com.fkfc.receitasapi.dao.ReceitaRepository;
import com.fkfc.receitasapi.dto.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Camada de abstração entre o controlador REST e o repositório de receitas.
 */
@Component
public class UpdateReceitaHandler {

    @Autowired
    ReceitaRepository receitaRepository;

    /**
     * Informa o repositório para modificar uma receita utilizando o método PATCH
     * @param partialReceita Instância da Receita com os campos a serem modificados
     * @param receitaId Número identificador da receita
     * @return Instância da receita com os campos modificados
     */
    public Receita handlePatchReceita(Receita partialReceita, Integer receitaId) {
        System.out.println("updating receita partial " + partialReceita.toString());
        receitaRepository.patchReceita(partialReceita, receitaId);
        return receitaRepository.getById(receitaId);
    }

    /**
     * Informa o repositório para modificar uma receita utilizando o método PUT
     * @param receita Instância da Receita contendo os novos valores dos campos
     * @param receitaId Número identificador da receita
     * @return Instância da receita com os novos valores
     */
    public Receita handlePutReceita(Receita receita, Integer receitaId) {
        receitaRepository.putReceita(receita, receitaId);
        return receitaRepository.getById(receitaId);
    }

}
