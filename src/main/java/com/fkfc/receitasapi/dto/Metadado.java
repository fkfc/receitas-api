package com.fkfc.receitasapi.dto;

/**
 * Modelo anêmico de um metadado de uma receita.
 * Inclui informação do nome e valor específico da receita.
 * Inclui método para representação em String no formato JSON.
 */
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
