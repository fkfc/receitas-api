package com.fkfc.receitasapi.dto;

public class Ingrediente {
    protected Integer ordem;
    protected String nome;
    protected String quantidade;

    public Ingrediente() {
    }

    public Ingrediente(Integer ordem, String nome, String quantidade) {
        this.ordem = ordem;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "{" +
                "ordem=" + ordem +
                ", nome='" + nome + '\'' +
                ", quantidade='" + quantidade + '\'' +
                '}';
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
