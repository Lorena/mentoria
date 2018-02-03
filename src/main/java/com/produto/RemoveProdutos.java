package com.produto;

import java.util.List;

public class RemoveProdutos {

    private List<Produto> produtos;

    public RemoveProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto removeProduto(int codigo) throws Exception {
        Produto produto = getProduto(codigo);
        if(produtos.remove(produto)) {
            return produto;
        }
        throw new Exception("Produto não removido!");
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