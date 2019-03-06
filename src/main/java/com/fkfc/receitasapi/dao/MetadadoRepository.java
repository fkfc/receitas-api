package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.Metadado;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repositório de metadados. Abstrai a utilização do banco de dados.
 */
@Repository
@Transactional
public class MetadadoRepository {

    @Autowired
    private DSLContext dslContext;

    private Metadado METADADO = Metadado.METADADO;

    /**
     * Salva um metadado no banco de dados. Se o metadado já existir, apenas retorna o número do ID do metadado.
     * @param nome Nome do metadado
     * @return Número do ID do metadado
     */
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

    /**
     * Busca um ID de um metadado a partir do nome
     * @param nome Nome do metadado a ser buscado
     * @return ID do metadado
     */
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

    /**
     * Busca o nome de um metadado a partir do ID
     * @param metadadoId ID do metadado a ser buscado
     * @return Nome do metadado
     */
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
