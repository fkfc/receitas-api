package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.Ingrediente;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repositório de ingredientes. Abstrai a utilização do banco de dados.
 */
@Repository
@Transactional
public class IngredienteRepository {

    @Autowired
    private DSLContext dslContext;

    private Ingrediente INGREDIENTE = Ingrediente.INGREDIENTE;

    /**
     * Salva um ingrediente no banco de dados. Se o ingrediente já existir, apenas retorna o número do ID do ingrediente.
     * @param nome Nome do ingrediente
     * @return Número do ID do ingrediente
     */
    public Integer saveIngrediente(String nome) {
        try {
            return dslContext
                    .selectFrom(INGREDIENTE)
                    .where(INGREDIENTE.NOME.eq(nome))
                    .fetchOne().getId();
        } catch (NullPointerException e) {
            return dslContext
                    .insertInto(INGREDIENTE, INGREDIENTE.NOME)
                    .values(nome).returning(INGREDIENTE.ID)
                    .fetchOne().getId();
        }
    }

    /**
     * Busca um ID de um ingrediente a partir do nome
     * @param nome Nome do ingrediente a ser buscado
     * @return ID do ingrediente
     */
    public Integer getByNome(String nome) {
        try {
            return dslContext
                    .selectFrom(INGREDIENTE)
                    .where(INGREDIENTE.NOME.eq(nome))
                    .fetchOne().getId();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Busca o nome de um ingrediente a partir do ID
     * @param ingredienteId ID do ingrediente a ser buscado
     * @return Nome do ingrediente
     */
    public String getById(Integer ingredienteId) {
        try {
            return dslContext
                    .selectFrom(INGREDIENTE)
                    .where(INGREDIENTE.ID.eq(ingredienteId))
                    .fetchOne().getNome();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
