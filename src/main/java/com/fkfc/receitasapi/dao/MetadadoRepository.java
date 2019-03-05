package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.Metadado;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MetadadoRepository {

    @Autowired
    private DSLContext dslContext;

    private Metadado METADADO = Metadado.METADADO;

    public Integer saveMetadado(String nome) {
        try {
            return dslContext
                    .selectFrom(METADADO)
                    .where(METADADO.NOME.eq(nome))
                    .fetchOne().getId();
        } catch (NullPointerException e) {
            return dslContext
                    .insertInto(METADADO, METADADO.NOME)
                    .values(nome).returning(METADADO.ID)
                    .fetchOne().getId();
        }
    }

    public Integer getByNome(String nome) {
        try {
            return dslContext
                    .selectFrom(METADADO)
                    .where(METADADO.NOME.eq(nome))
                    .fetchOne().getId();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String getById(Integer metadadoId) {
        try {
            return dslContext
                    .selectFrom(METADADO)
                    .where(METADADO.ID.eq(metadadoId))
                    .fetchOne().getNome();
        } catch (NullPointerException e) {
            return null;
        }
    }


}
