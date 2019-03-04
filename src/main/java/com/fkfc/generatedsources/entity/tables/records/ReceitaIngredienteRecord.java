/*
 * This file is generated by jOOQ.
 */
package com.fkfc.generatedsources.entity.tables.records;


import com.fkfc.generatedsources.entity.tables.ReceitaIngrediente;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class ReceitaIngredienteRecord extends UpdatableRecordImpl<ReceitaIngredienteRecord> implements Record4<Integer, Integer, Integer, String> {

    private static final long serialVersionUID = -1751389392;

    /**
     * Setter for <code>receitas.receita_ingrediente.receita_id</code>.
     */
    public void setReceitaId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>receitas.receita_ingrediente.receita_id</code>.
     */
    public Integer getReceitaId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>receitas.receita_ingrediente.ingrediente_id</code>.
     */
    public void setIngredienteId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>receitas.receita_ingrediente.ingrediente_id</code>.
     */
    public Integer getIngredienteId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>receitas.receita_ingrediente.ordem</code>.
     */
    public void setOrdem(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>receitas.receita_ingrediente.ordem</code>.
     */
    public Integer getOrdem() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>receitas.receita_ingrediente.quantidade</code>.
     */
    public void setQuantidade(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>receitas.receita_ingrediente.quantidade</code>.
     */
    public String getQuantidade() {
        return (String) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ReceitaIngrediente.RECEITA_INGREDIENTE.RECEITA_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ReceitaIngrediente.RECEITA_INGREDIENTE.INGREDIENTE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return ReceitaIngrediente.RECEITA_INGREDIENTE.ORDEM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ReceitaIngrediente.RECEITA_INGREDIENTE.QUANTIDADE;
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
        return getIngredienteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getOrdem();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getQuantidade();
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
        return getIngredienteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getOrdem();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getQuantidade();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaIngredienteRecord value1(Integer value) {
        setReceitaId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaIngredienteRecord value2(Integer value) {
        setIngredienteId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaIngredienteRecord value3(Integer value) {
        setOrdem(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaIngredienteRecord value4(String value) {
        setQuantidade(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReceitaIngredienteRecord values(Integer value1, Integer value2, Integer value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReceitaIngredienteRecord
     */
    public ReceitaIngredienteRecord() {
        super(ReceitaIngrediente.RECEITA_INGREDIENTE);
    }

    /**
     * Create a detached, initialised ReceitaIngredienteRecord
     */
    public ReceitaIngredienteRecord(Integer receitaId, Integer ingredienteId, Integer ordem, String quantidade) {
        super(ReceitaIngrediente.RECEITA_INGREDIENTE);

        set(0, receitaId);
        set(1, ingredienteId);
        set(2, ordem);
        set(3, quantidade);
    }
}