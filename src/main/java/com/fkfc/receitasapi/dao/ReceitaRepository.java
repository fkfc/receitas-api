package com.fkfc.receitasapi.dao;

import com.fkfc.generatedsources.entity.tables.pojos.ReceitaMetadado;
import com.fkfc.generatedsources.entity.tables.pojos.ReceitaCategoria;
import com.fkfc.generatedsources.entity.tables.pojos.ReceitaIngrediente;
import com.fkfc.receitasapi.dto.Ingrediente;
import com.fkfc.receitasapi.dto.Metadado;
import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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


    public void saveReceita(Receita receita) {

        //Salva a tabela da Receita
        Integer receitaId = dslContext
                                .insertInto(RECEITA, RECEITA.NOME, RECEITA.MODO_PREPARO)
                                .values(receita.getNome(), receita.getModoPreparo())
                                .returning(RECEITA.ID)
                                .fetchOne().getId();
        System.out.println("receita ID " + receitaId);
        //Associa a receita às categorias, adicionando novas quando necessário
        for (String categoria: receita.getCategorias()) {
            Integer categoriaId = categoriaRepository.saveCategoria(categoria);
            dslContext
                    .insertInto(RECEITA_CATEGORIA, RECEITA_CATEGORIA.RECEITA_ID, RECEITA_CATEGORIA.CATEGORIA_ID)
                    .values(receitaId, categoriaId)
                    .execute();
        }

        //Salva os ingredientes, adicionando novos ingredientes à sua tabela quando necessário
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

        //Salva os metadados com os seus valores, adicionando os nomes dos metadados em sua tabela quando necessário
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


    Receita getById(Integer receitaId) {
        Receita receita = new Receita();

        //Recupera a tabela 'Receita'
        BeanUtils.copyProperties(
            receita,
            dslContext
                    .selectFrom(RECEITA)
                    .where(RECEITA.ID.eq(receitaId))
                    .fetchOne()
                    .into(com.fkfc.generatedsources.entity.tables.pojos.Receita.class)
        );

        //Adiciona os ingredientes
        List<ReceitaIngrediente> receitaIngredientes =
            dslContext
                    .selectFrom(RECEITA_INGREDIENTE)
                    .where(RECEITA_INGREDIENTE.RECEITA_ID.eq(receitaId))
                    .fetch()
                    .into(ReceitaIngrediente.class);
        for (ReceitaIngrediente receitaIngrediente: receitaIngredientes) {
            receita.getIngredientes().add(
                new Ingrediente(
                    receitaIngrediente.getOrdem(),
                    ingredienteRepository.getById(receitaIngrediente.getIngredienteId()),
                    receitaIngrediente.getQuantidade()
                )
            );
        }

        //Adiciona as categorias
        List<ReceitaCategoria> receitaCategorias =
            dslContext
                .selectFrom(RECEITA_CATEGORIA)
                .where(RECEITA_CATEGORIA.RECEITA_ID.eq(receitaId))
                .fetch()
                .into(ReceitaCategoria.class);
        for (ReceitaCategoria receitaCategoria: receitaCategorias) {
            receita.getCategorias().add(
                categoriaRepository.getById(receitaCategoria.getCategoriaId())
            );
        }

        //Adiciona os metadados
        List<ReceitaMetadado> receitaMetadados =
            dslContext
                .selectFrom(RECEITA_METADADO)
                .where(RECEITA_METADADO.RECEITA_ID.eq(receitaId))
                .fetch()
                .into(ReceitaMetadado.class);
        for (ReceitaMetadado receitaMetadado: receitaMetadados) {
            receita.getMetadados().add(
                new Metadado(
                        metadadoRepository.getById(receitaMetadado.getMetadadoId()),
                        receitaMetadado.getValor()
                )
            );
        }

        //retorna a instância
        return receita;

    }

    //Retorna uma lista de receitas filtrada pelo parâmetro filter
    List<Receita> getByFilter(ReceitaFilter filter) {
        SelectWhereStep query = dslContext.
                                    select()
                                        .from(
                                            RECEITA
                                                .join(RECEITA_CATEGORIA)
                                                    .on(RECEITA.ID.eq(RECEITA_CATEGORIA.RECEITA_ID))
                                                .join(RECEITA_INGREDIENTE)
                                                    .on(RECEITA.ID.eq(RECEITA_INGREDIENTE.RECEITA_ID))
                                                .join(RECEITA_METADADO)
                                                    .on(RECEITA.ID.eq(RECEITA_METADADO.RECEITA_ID))

                                        );

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
                whereConditions.add(RECEITA_CATEGORIA.CATEGORIA_ID.eq(categoriaId));

            }
        }
        //Ingredientes
        if (filter.getIngredientes() != null) {
            for (String ingrediente: filter.getIngredientes()) {
                Integer ingredienteId = ingredienteRepository.getByNome(ingrediente);
                whereConditions.add(RECEITA_INGREDIENTE.INGREDIENTE_ID.eq(ingredienteId));
            }
        }

        //Adiciona as condições do filtro à query
        query.where(DSL.and(whereConditions));

        //Recupera os IDs das receitas que satisfazem as condições da busca
        List<Integer> receitaIds = query.fetch(RECEITA.ID, Integer.class);

        //Instancia cada uma das receitas que satisfazem a busca
        List<Receita> receitas = new ArrayList<>();
        for (Integer receitaId: receitaIds) {
            receitas.add(this.getById(receitaId));
        }

        return receitas;
    }

}
