package com.fkfc.receitasapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ReceitaFilter {
    protected String nome = null;
    protected List<String> ingredientes = new ArrayList<>();
    protected List<String> categorias = new ArrayList<>();

    public ReceitaFilter() {
    }

    public ReceitaFilter(String nome, List<String> ingredientes, List<String> categorias) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.categorias = categorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

}