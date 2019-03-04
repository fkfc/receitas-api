/*
 * This file is generated by jOOQ.
 */
package com.fkfc.generatedsources.entity.tables.records;


import com.fkfc.generatedsources.entity.tables.ReceitaCategoria;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ReceitaCategoriaRecord extends UpdatableRecordImpl<ReceitaCategoriaRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1478929472;

    /**
     * Setter for <code>receitas.receita_categoria.receita_id</code>.
     */
    public void setReceitaId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>receitas.receita_categoria.receita_id</code>.
     */
    public Integer getReceitaId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>receitas.receita_categoria.categoria_id</code>.
     */
    public void setCategoriaId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>receitas.receita_categoria.categoria_id</code>.
     */
    public Integer getCategoriaId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ReceitaCategoria.RECEITA_CATEGORIA.RECEITA_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ReceitaCategoria.RECEITA_CATEGORIA.CATEGORIA_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getReceitaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getCategoriaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getReceitaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCategoriaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaCategoriaRecord value1(Integer value) {
        setReceitaId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaCategoriaRecord value2(Integer value) {
        setCategoriaId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaCategoriaRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReceitaCategoriaRecord
     */
    public ReceitaCategoriaRecord() {
        super(ReceitaCategoria.RECEITA_CATEGORIA);
    }

    /**
     * Create a detached, initialised ReceitaCategoriaRecord
     */
    public ReceitaCategoriaRecord(Integer receitaId, Integer categoriaId) {
        super(ReceitaCategoria.RECEITA_CATEGORIA);

        set(0, receitaId);
        set(1, categoriaId);
    }
}