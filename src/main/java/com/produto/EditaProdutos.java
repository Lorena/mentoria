package com.produto;

import java.util.List;

public class EditaProdutos {

    private List<Produto> produtos;

    public EditaProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto editaNome(int codigo, String nome) throws Exception {
        //Erica fazer
        return null;
    }

    private Produto getProduto(int codigo) throws Exception {
        for(Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        throw new Exception("Produto não encontrado!");
    }
}