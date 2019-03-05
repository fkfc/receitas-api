package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.Categoria;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoriaRepository {

    @Autowired
    private DSLContext dslContext;

    private Categoria CATEGORIA = Categoria.CATEGORIA;

    public Integer saveCategoria(String nome) {
        try {
            return dslContext
                    .selectFrom(CATEGORIA)
                    .where(CATEGORIA.NOME.eq(nome))
                    .fetchOne().getId();
        } catch (NullPointerException e) {
            return dslContext
                    .insertInto(CATEGORIA, CATEGORIA.NOME)
                    .values(nome).returning(CATEGORIA.ID)
                    .fetchOne().getId();
        }
    }

    public Integer getByNome(String nome) {
        try {
            return dslContext
                    .selectFrom(CATEGORIA)
                    .where(CATEGORIA.NOME.eq(nome))
                    .fetchOne().getId();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public String getById(Integer categoriaId) {
        try {
            return dslContext
                    .selectFrom(CATEGORIA)
                    .where(CATEGORIA.ID.eq(categoriaId))
                    .fetchOne().getNome();
        } catch (NullPointerException e) {
            return null;
        }
    }

}
