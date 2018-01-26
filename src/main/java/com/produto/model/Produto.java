package com.produto.model;

import java.util.Date;

public class Produto {
        private int codigo;
        private String nome;
        private double preco;
        private int quantidadeEstoque;
        private int estoqueMinima;
        private Date dataCadastro;

    public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueMinimo,
                       Date dataCadastro) {
            super();
            this.codigo = codigo;
            this.nome = nome;
            this.preco = precoUnitario;
            this.quantidadeEstoque = estoque;
            this.estoqueMinima = estoqueMinimo;
            this.dataCadastro = dataCadastro;
        }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int getEstoqueMinima() {
        return estoqueMinima;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
}