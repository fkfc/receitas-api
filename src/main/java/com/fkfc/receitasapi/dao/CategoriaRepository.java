package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.Categoria;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repositório de categorias. Abstrai a utilização do banco de dados.
 */
@Repository
@Transactional
public class CategoriaRepository {

    @Autowired
    private DSLContext dslContext;

    private Categoria CATEGORIA = Categoria.CATEGORIA;

    /**
     * Salva uma categoria no banco de dados. Se a categoria já existir, apenas retorna o número do ID da categoria.
     * @param nome Nome da categoria
     * @return Número do ID da categoria
     */
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

    /**
     * Busca um ID de uma categoria a partir do nome
     * @param nome Nome da categoria a ser buscada
     * @return ID da categoria
     */
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

    /**
     * Busca o nome de uma categoria a partir do ID
     * @param categoriaId ID da categoria a ser buscada
     * @return Nome da categoria
     */
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
