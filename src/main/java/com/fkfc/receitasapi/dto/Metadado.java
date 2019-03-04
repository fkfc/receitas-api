package com.fkfc.receitasapi.dto;

public class Metadado {
    protected String nome;
    protected String valor;

    public Metadado() {
    }

    public Metadado(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
