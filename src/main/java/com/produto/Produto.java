package com.produto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
        private int codigo;
        private String nome;
        private double preco;
        private int quantidadeEstoque;
        private int estoqueMinima;
        private Date dataCadastro;

    public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueMinimo,
                       Date dataCadastro) throws Exception{
        if(codigo == 0 || validaDataCadastro(dataCadastro)) {
            throw new Exception("Produto não cadastrado");
        }
            this.codigo = codigo;
            this.nome = nome;
            this.preco = precoUnitario;
            this.quantidadeEstoque = estoque;
            this.estoqueMinima = estoqueMinimo;
            this.dataCadastro = dataCadastro;
        }

    private boolean validaDataCadastro(Date dataCadastro) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateAtualString = dateFormat.format(new Date());
        Date dataAtual = dateFormat.parse(dateAtualString);
        return dataCadastro.after(dataAtual);
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public double getPreco() {
        return preco;
    }
}