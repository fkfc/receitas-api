/*
 * This file is generated by jOOQ.
 */
package com.fkfc.generatedsources.entity.tables;


import com.fkfc.generatedsources.entity.Indexes;
import com.fkfc.generatedsources.entity.Keys;
import com.fkfc.generatedsources.entity.Receitas;
import com.fkfc.generatedsources.entity.tables.records.ReceitaRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Receita extends TableImpl<ReceitaRecord> {

    private static final long serialVersionUID = 822695900;

    /**
     * The reference instance of <code>receitas.receita</code>
     */
    public static final Receita RECEITA = new Receita();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReceitaRecord> getRecordType() {
        return ReceitaRecord.class;
    }

    /**
     * The column <code>receitas.receita.id</code>.
     */
    public final TableField<ReceitaRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>receitas.receita.nome</code>.
     */
    public final TableField<ReceitaRecord, String> NOME = createField("nome", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>receitas.receita.modo_preparo</code>.
     */
    public final TableField<ReceitaRecord, String> MODO_PREPARO = createField("modo_preparo", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>receitas.receita</code> table reference
     */
    public Receita() {
        this(DSL.name("receita"), null);
    }

    /**
     * Create an aliased <code>receitas.receita</code> table reference
     */
    public Receita(String alias) {
        this(DSL.name(alias), RECEITA);
    }

    /**
     * Create an aliased <code>receitas.receita</code> table reference
     */
    public Receita(Name alias) {
        this(alias, RECEITA);
    }

    private Receita(Name alias, Table<ReceitaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Receita(Name alias, Table<ReceitaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Receita(Table<O> child, ForeignKey<O, ReceitaRecord> key) {
        super(child, key, RECEITA);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Receitas.RECEITAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.RECEITA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ReceitaRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RECEITA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ReceitaRecord> getPrimaryKey() {
        return Keys.KEY_RECEITA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ReceitaRecord>> getKeys() {
        return Arrays.<UniqueKey<ReceitaRecord>>asList(Keys.KEY_RECEITA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Receita as(String alias) {
        return new Receita(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Receita as(Name alias) {
        return new Receita(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Receita rename(String name) {
        return new Receita(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Receita rename(Name name) {
        return new Receita(name, null);
    }
}
