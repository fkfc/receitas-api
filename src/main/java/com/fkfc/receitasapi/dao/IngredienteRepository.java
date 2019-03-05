package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.Ingrediente;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IngredienteRepository {

    @Autowired
    private DSLContext dslContext;

    private Ingrediente INGREDIENTE = Ingrediente.INGREDIENTE;

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
