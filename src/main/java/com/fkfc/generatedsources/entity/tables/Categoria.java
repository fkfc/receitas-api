/*
 * This file is generated by jOOQ.
 */
package com.fkfc.generatedsources.entity.tables;


import com.fkfc.generatedsources.entity.Indexes;
import com.fkfc.generatedsources.entity.Keys;
import com.fkfc.generatedsources.entity.Receitas;
import com.fkfc.generatedsources.entity.tables.records.CategoriaRecord;

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
public class Categoria extends TableImpl<CategoriaRecord> {

    private static final long serialVersionUID = -625173456;

    /**
     * The reference instance of <code>receitas.categoria</code>
     */
    public static final Categoria CATEGORIA = new Categoria();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CategoriaRecord> getRecordType() {
        return CategoriaRecord.class;
    }

    /**
     * The column <code>receitas.categoria.id</code>.
     */
    public final TableField<CategoriaRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>receitas.categoria.nome</code>.
     */
    public final TableField<CategoriaRecord, String> NOME = createField("nome", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>receitas.categoria</code> table reference
     */
    public Categoria() {
        this(DSL.name("categoria"), null);
    }

    /**
     * Create an aliased <code>receitas.categoria</code> table reference
     */
    public Categoria(String alias) {
        this(DSL.name(alias), CATEGORIA);
    }

    /**
     * Create an aliased <code>receitas.categoria</code> table reference
     */
    public Categoria(Name alias) {
        this(alias, CATEGORIA);
    }

    private Categoria(Name alias, Table<CategoriaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Categoria(Name alias, Table<CategoriaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Categoria(Table<O> child, ForeignKey<O, CategoriaRecord> key) {
        super(child, key, CATEGORIA);
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
        return Arrays.<Index>asList(Indexes.CATEGORIA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CategoriaRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CATEGORIA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CategoriaRecord> getPrimaryKey() {
        return Keys.KEY_CATEGORIA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CategoriaRecord>> getKeys() {
        return Arrays.<UniqueKey<CategoriaRecord>>asList(Keys.KEY_CATEGORIA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Categoria as(String alias) {
        return new Categoria(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Categoria as(Name alias) {
        return new Categoria(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Categoria rename(String name) {
        return new Categoria(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Categoria rename(Name name) {
        return new Categoria(name, null);
    }
}
