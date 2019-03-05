package com.fkfc.receitasapi.dto;

import java.util.ArrayList;
import java.util.List;

public class Receita {
    protected Integer id;
    protected String nome;
    protected List<String> categorias = new ArrayList<>();
    protected List<Ingrediente> ingredientes = new ArrayList<>();
    protected List<Metadado> metadados = new ArrayList<>();
    protected String modoPreparo;

    public Receita() {
    }

    public Receita(String nome, List<String> categorias, List<Ingrediente> ingredientes, List<Metadado> metadados, String modoPreparo) {
        this.nome = nome;
        this.categorias = categorias;
        this.ingredientes = ingredientes;
        this.metadados = metadados;
        this.modoPreparo = modoPreparo;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", categorias=" + categorias +
                ", ingredientes=" + ingredientes +
                ", metadados=" + metadados +
                ", modoPreparo='" + modoPreparo + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Metadado> getMetadados() {
        return metadados;
    }

    public void setMetadados(List<Metadado> metadados) {
        this.metadados = metadados;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
