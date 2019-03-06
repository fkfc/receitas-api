package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.pojos.ReceitaMetadado;
import com.fkfc.generatedsources.entity.tables.pojos.ReceitaCategoria;
import com.fkfc.generatedsources.entity.tables.pojos.ReceitaIngrediente;
import com.fkfc.generatedsources.entity.tables.records.ReceitaRecord;
import com.fkfc.receitasapi.dto.Ingrediente;
import com.fkfc.receitasapi.dto.Metadado;
import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Repositório de receitas. Abstrai a utilização do banco de dados.
 */
@Repository
@Transactional
public class ReceitaRepository {

    @Autowired
    private DSLContext dslContext;

    //Atalhos para os nomes das tabelas
    private com.fkfc.generatedsources.entity.tables.Receita RECEITA = com.fkfc.generatedsources.entity.tables.Receita.RECEITA;
    private com.fkfc.generatedsources.entity.tables.ReceitaCategoria RECEITA_CATEGORIA = com.fkfc.generatedsources.entity.tables.ReceitaCategoria.RECEITA_CATEGORIA;
    private com.fkfc.generatedsources.entity.tables.ReceitaIngrediente RECEITA_INGREDIENTE = com.fkfc.generatedsources.entity.tables.ReceitaIngrediente.RECEITA_INGREDIENTE;
    private com.fkfc.generatedsources.entity.tables.ReceitaMetadado RECEITA_METADADO = com.fkfc.generatedsources.entity.tables.ReceitaMetadado.RECEITA_METADADO;

    //Repositórios - lidam os is IDs das tabelas referenciadas
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Autowired
    MetadadoRepository metadadoRepository;


    /**
     * Salva uma nova receita no banco de dados
     * @param receita Instância (DTO) da nova receita
     */
    public void saveReceita(Receita receita) {

        //Salva a tabela da Receita
        Integer receitaId = dslContext
                                .insertInto(RECEITA, RECEITA.NOME, RECEITA.MODO_PREPARO)
                                .values(receita.getNome(), receita.getModoPreparo())
                                .returning(RECEITA.ID)
                                .fetchOne().getId();

        setCategorias(receita, receitaId);
        setIngredientes(receita, receitaId);
        setMetadados(receita, receitaId);
    }

    /**
     * Associa a receita às categorias, adicionando novas quando necessário
     * @param receita Instância DTO da receita
     * @param receitaId ID da receita, para ser utilizada na chave estrangeira da tabela
     */
    private void setCategorias(Receita receita, Integer receitaId) {
        for (String categoria: receita.getCategorias()) {
            Integer categoriaId = categoriaRepository.saveCategoria(categoria);
            dslContext
                    .insertInto(RECEITA_CATEGORIA, RECEITA_CATEGORIA.RECEITA_ID, RECEITA_CATEGORIA.CATEGORIA_ID)
                    .values(receitaId, categoriaId)
                    .execute();
        }
    }


    /**
     * Salva os ingredientes, adicionando novos ingredientes à sua tabela quando necessário
     * @param receita Instância DTO da receita
     * @param receitaId ID da receita, para ser utilizada na chave estrangeira da tabela
     */
    private void setIngredientes(Receita receita, Integer receitaId) {
        for (Ingrediente ingrediente: receita.getIngredientes()) {
            Integer ingredienteId = ingredienteRepository.saveIngrediente(ingrediente.getNome());
            dslContext
                    .insertInto(RECEITA_INGREDIENTE,
                            RECEITA_INGREDIENTE.RECEITA_ID,
                            RECEITA_INGREDIENTE.INGREDIENTE_ID,
                            RECEITA_INGREDIENTE.ORDEM,
                            RECEITA_INGREDIENTE.QUANTIDADE
                    )
                    .values(receitaId, ingredienteId, ingrediente.getOrdem(), ingrediente.getQuantidade())
                    .execute();
        }
    }

    /**
     * Salva os metadados com os seus valores, adicionando os nomes dos metadados em sua tabela quando necessário
     * @param receita Instância DTO da receita
     * @param receitaId ID da receita, para ser utilizada na chave estrangeira da tabela
     */
    private void setMetadados(Receita receita, Integer receitaId) {
        for (Metadado metadado: receita.getMetadados()) {
            Integer metadadoId = metadadoRepository.saveMetadado(metadado.getNome());
            dslContext
                    .insertInto(RECEITA_METADADO,
                            RECEITA_METADADO.RECEITA_ID,
                            RECEITA_METADADO.METADADO_ID,
                            RECEITA_METADADO.VALOR
                    )
                    .values(receitaId, metadadoId, metadado.getValor())
                    .execute();
        }
    }

    /**
     * Exclui todas as categorias de uma receita
     * @param receitaId ID da receita
     */
    private void deleteCategorias(Integer receitaId) {
        dslContext.deleteFrom(RECEITA_CATEGORIA).where(RECEITA_CATEGORIA.RECEITA_ID.eq(receitaId)).execute();
    }

    /**
     * Exclui todos os ingredientes de uma receita
     * @param receitaId ID da receita
     */
    private void deleteIngredientes(Integer receitaId) {
        dslContext.deleteFrom(RECEITA_INGREDIENTE).where(RECEITA_INGREDIENTE.RECEITA_ID.eq(receitaId)).execute();
    }

    /**
     * Exclui todos os metadados de uma receita
     * @param receitaId ID da receita
     */
    private void deleteMetadados(Integer receitaId) {
        dslContext.deleteFrom(RECEITA_METADADO).where(RECEITA_METADADO.RECEITA_ID.eq(receitaId)).execute();
    }

    /**
     * Retorna uma receita a partir do número do ID
     * @param receitaId ID da receita a ser recuperada no banco de dados
     * @return Instância (DTO) da receita
     */
    public Receita getById(Integer receitaId) {
        Receita receita = new Receita();

        //Recupera a tabela 'Receita'
        com.fkfc.generatedsources.entity.tables.pojos.Receita receitaPojo =
            dslContext
                .selectFrom(RECEITA)
                .where(RECEITA.ID.eq(receitaId))
                .fetchOne()
                .into(com.fkfc.generatedsources.entity.tables.pojos.Receita.class);
        receita.setId(receitaPojo.getId());
        receita.setNome(receitaPojo.getNome());
        receita.setModoPreparo(receitaPojo.getModoPreparo());

        //Adiciona os ingredientes
        List<ReceitaIngrediente> receitaIngredientes =
            dslContext
                    .selectFrom(RECEITA_INGREDIENTE)
                    .where(RECEITA_INGREDIENTE.RECEITA_ID.eq(receitaId))
                    .fetch()
                    .into(ReceitaIngrediente.class);
        List<Ingrediente> ingredientes = new ArrayList<>();
        for (ReceitaIngrediente receitaIngrediente: receitaIngredientes) {
            ingredientes.add(
                new Ingrediente(
                    receitaIngrediente.getOrdem(),
                    ingredienteRepository.getById(receitaIngrediente.getIngredienteId()),
                    receitaIngrediente.getQuantidade()
                )
            );
        }
        receita.setIngredientes(ingredientes);

        //Adiciona as categorias
        List<ReceitaCategoria> receitaCategorias =
            dslContext
                .selectFrom(RECEITA_CATEGORIA)
                .where(RECEITA_CATEGORIA.RECEITA_ID.eq(receitaId))
                .fetch()
                .into(ReceitaCategoria.class);
        List<String> categorias = new ArrayList<>();
        for (ReceitaCategoria receitaCategoria: receitaCategorias) {
            categorias.add(
                categoriaRepository.getById(receitaCategoria.getCategoriaId())
            );
        }
        receita.setCategorias(categorias);

        //Adiciona os metadados
        List<ReceitaMetadado> receitaMetadados =
            dslContext
                .selectFrom(RECEITA_METADADO)
                .where(RECEITA_METADADO.RECEITA_ID.eq(receitaId))
                .fetch()
                .into(ReceitaMetadado.class);
        List<Metadado> metadados = new ArrayList<>();
        for (ReceitaMetadado receitaMetadado: receitaMetadados) {
            metadados.add(
                new Metadado(
                        metadadoRepository.getById(receitaMetadado.getMetadadoId()),
                        receitaMetadado.getValor()
                )
            );
        }
        receita.setMetadados(metadados);

        //retorna a instância
        return receita;
    }


    /**
     * Retorna uma lista de receitas selecionadas a partir de um filtro
     * @param filter Instância (DTO) do filtro
     * @return Lista de instâncias de receitas
     */
    public List<Receita> getByFilter(ReceitaFilter filter) {
        SelectWhereStep query = dslContext.
                                    selectDistinct(RECEITA.ID)
                                        .from(RECEITA);

        //Adiciona condições do filtro
        Collection<Condition> whereConditions = new ArrayList<>();
        //Nome
        if (filter.getNome() != null && filter.getNome().length() > 0) {
            whereConditions.add(RECEITA.NOME.eq(filter.getNome()));
        }
        //Categoria
        if (filter.getCategorias() != null) {
            for (String categoria: filter.getCategorias()) {
                Integer categoriaId = categoriaRepository.getByNome(categoria);
                whereConditions.add(
                    RECEITA.ID.in(
                            dslContext
                                    .selectFrom(RECEITA_CATEGORIA)
                                    .where(RECEITA_CATEGORIA.CATEGORIA_ID.eq(categoriaId))
                                    .fetch(RECEITA_CATEGORIA.RECEITA_ID)
                    )
                );
            }
        }
        //Ingredientes
        if (filter.getIngredientes() != null) {
            for (String ingrediente: filter.getIngredientes()) {
                Integer ingredienteId = ingredienteRepository.getByNome(ingrediente);
                whereConditions.add(
                        RECEITA.ID.in(
                                dslContext
                                        .selectFrom(RECEITA_INGREDIENTE)
                                        .where(RECEITA_INGREDIENTE.INGREDIENTE_ID.eq(ingredienteId))
                                        .fetch(RECEITA_INGREDIENTE.RECEITA_ID)
                        )
                );
            }
        }

        //Adiciona as condições do filtro à query
        query
            .where(DSL.and(whereConditions));

        //Recupera os IDs das receitas que satisfazem as condições da busca
        List<Integer> receitaIds = query.fetch(RECEITA.ID, Integer.class);

        //Instancia cada uma das receitas que satisfazem a busca
        List<Receita> receitas = new ArrayList<>();
        for (Integer receitaId: receitaIds) {
            receitas.add(this.getById(receitaId));
        }

        return receitas;
    }

    /**
     * Modifica uma receita a partir de um patch. Campos nulos indicam campos que não serão alterados.
     * @param partialReceita Instância de uma receita, contendo apenas os campos a serem modificados
     * @param receitaId ID da receita a ser alterada
     */
    public void patchReceita(Receita partialReceita, Integer receitaId) {
        //Dados da tabela 'Receitas'
        ReceitaRecord receitaRecord = dslContext.selectFrom(RECEITA).where(RECEITA.ID.eq(receitaId)).fetchAny();

        //Nome
        if (partialReceita.getNome() != null) {
            receitaRecord.setNome(partialReceita.getNome());
        }

        //Modo de preparo
        if (partialReceita.getModoPreparo() != null) {
            receitaRecord.setModoPreparo(partialReceita.getModoPreparo());
        }
        receitaRecord.store();

        //Categorias
        if (partialReceita.getCategorias() != null) {
            deleteCategorias(receitaId);
            setCategorias(partialReceita, receitaId);
        }

        //Metadados
        if (partialReceita.getMetadados() != null) {
            deleteMetadados(receitaId);
            setMetadados(partialReceita, receitaId);
        }

        //Ingredientes
        if (partialReceita.getIngredientes() != null) {
            deleteIngredientes(receitaId);
            setIngredientes(partialReceita, receitaId);
        }
    }

    /**
     * Altera completamente uma receita. Campos definidos como nulo são interpretados como campos a serem apagados.
     * @param receita Instância DTO da receita
     * @param receitaId ID da receita a ser alterada
     */
    public void putReceita(Receita receita, Integer receitaId) {
        //Dados da tabela 'Receitas'
        ReceitaRecord receitaRecord = dslContext.selectFrom(RECEITA).where(RECEITA.ID.eq(receitaId)).fetchAny();
        receitaRecord.setNome(receita.getNome());
        receitaRecord.setModoPreparo(receita.getModoPreparo());
        receitaRecord.store();

        //Categorias
        deleteCategorias(receitaId);
        setCategorias(receita, receitaId);

        //Metadados
        deleteMetadados(receitaId);
        setMetadados(receita, receitaId);

        //Ingredientes
        deleteIngredientes(receitaId);
        setIngredientes(receita, receitaId);
    }

    /**
     * Exclui uma receita do banco de dados
     * @param receitaId ID da receita a ser excluída
     */
    public void deleteReceita(Integer receitaId) {
        deleteCategorias(receitaId);
        deleteMetadados(receitaId);
        deleteIngredientes(receitaId);
        dslContext.deleteFrom(RECEITA).where(RECEITA.ID.eq(receitaId)).execute();
    }

}
