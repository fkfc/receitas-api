/*
 * This file is generated by jOOQ.
 */
package com.fkfc.generatedsources.entity.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1608884330;

    private Integer id;
    private String  nome;

    public Categoria() {}

    public Categoria(Categoria value) {
        this.id = value.id;
        this.nome = value.nome;
    }

    public Categoria(
        Integer id,
        String  nome
    ) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Categoria (");

        sb.append(id);
        sb.append(", ").append(nome);

        sb.append(")");
        return sb.toString();
    }
}
