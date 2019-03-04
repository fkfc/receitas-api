package com.fkfc.receitasapi.dao;

import com.fkfc.receitasapi.dto.Ingrediente;
import com.fkfc.receitasapi.dto.Metadado;
import com.fkfc.receitasapi.dto.Receita;
import com.fkfc.receitasapi.dto.ReceitaFilter;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        int filterFieldCount = 0;
        if (filter.getNome() != null && filter.getNome().length() > 0) {
            filterFieldCount++;
            query.where(RECEITA.NOME.eq(filter.getNome());
        }
        if (filter.getCategorias() != null && filter.getCategorias().size() > 0) {
            filterFieldCount++;
            for (String categoria: filter.getCategorias()) {
                Integer categoriaId = categoriaRepository.getByNome(categoria);
                query.where(RECEITA_CATEGORIA.CATEGORIA_ID.eq(categoriaId));
            }
        }
        //TODO INGREDIENTE

        List<Integer> receitaIds = query.fetch().getValues(RECEITA.ID);

        //TODO GET BY ID



    }

}
