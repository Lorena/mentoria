package com.produto;

import com.produto.model.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastraProdutos {

    private List<Produto> produtos = new ArrayList<Produto>();

    public List<Produto> cadastraProdutos(int codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinima, Date dataCadastro) throws Exception {
         produtos.add(new Produto(codigo, nome, preco, quantidadeEstoque, estoqueMinima, dataCadastro));
        return produtos;
    }

    public List<Produto> getProdutosCadastrados() {
        return produtos;
    }
}