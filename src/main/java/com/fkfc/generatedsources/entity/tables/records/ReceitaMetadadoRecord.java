/*
 * This file is generated by jOOQ.
 */
package com.fkfc.generatedsources.entity.tables.records;


import com.fkfc.generatedsources.entity.tables.ReceitaMetadado;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class ReceitaMetadadoRecord extends UpdatableRecordImpl<ReceitaMetadadoRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 1090124196;

    /**
     * Setter for <code>receitas.receita_metadado.receita_id</code>.
     */
    public void setReceitaId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>receitas.receita_metadado.receita_id</code>.
     */
    public Integer getReceitaId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>receitas.receita_metadado.metadado_id</code>.
     */
    public void setMetadadoId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>receitas.receita_metadado.metadado_id</code>.
     */
    public Integer getMetadadoId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>receitas.receita_metadado.valor</code>.
     */
    public void setValor(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>receitas.receita_metadado.valor</code>.
     */
    public String getValor() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ReceitaMetadado.RECEITA_METADADO.RECEITA_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ReceitaMetadado.RECEITA_METADADO.METADADO_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ReceitaMetadado.RECEITA_METADADO.VALOR;
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
        return getMetadadoId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getValor();
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
        return getMetadadoId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaMetadadoRecord value1(Integer value) {
        setReceitaId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaMetadadoRecord value2(Integer value) {
        setMetadadoId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaMetadadoRecord value3(String value) {
        setValor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaMetadadoRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReceitaMetadadoRecord
     */
    public ReceitaMetadadoRecord() {
        super(ReceitaMetadado.RECEITA_METADADO);
    }

    /**
     * Create a detached, initialised ReceitaMetadadoRecord
     */
    public ReceitaMetadadoRecord(Integer receitaId, Integer metadadoId, String valor) {
        super(ReceitaMetadado.RECEITA_METADADO);

        set(0, receitaId);
        set(1, metadadoId);
        set(2, valor);
    }
}
