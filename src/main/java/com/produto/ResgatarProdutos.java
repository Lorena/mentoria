package com.produto;

import com.produto.model.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResgatarProdutos {
    private List<Produto> produtos;

    public ResgatarProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutosComPrecoMaiorDoQuePrecoInformado(int precoInformado) {
        List<Produto> produtosComPrecoMaior = new ArrayList<Produto>();
        for(Produto produto : produtos){
            if(produto.getPreco() > precoInformado){
                produtosComPrecoMaior.add(produto);
            }
        }
        return produtosComPrecoMaior;
    }

    public List<Produto> getProdutosPorData(Date dataCadastro){
        List<Produto> produtoCadastradoNestaData = new ArrayList<Produto>();
        for(Produto produto : produtos){
            if(produto.getDataCadastro().equals(dataCadastro)){
                produtoCadastradoNestaData.add(produto);
            }
        }
        return produtoCadastradoNestaData;
    }

    public List<Produto> getProdutosPorNome(String nome) {
        List<Produto> produtoPesquisadoPorNome = new ArrayList<Produto>();
        for(Produto produto : produtos){
            if(produto.getNome().equals(nome)){
                produtoPesquisadoPorNome.add(produto);
            }
        }
        return produtoPesquisadoPorNome;
    }

    public List<Produto> getProdutosTemNoEstoque() {
        List<Produto> produtoQueTemNoEstoque = new ArrayList<Produto>();
        for(Produto produto : produtos) {
            if(produto.getQuantidadeEstoque() != 0) {
                produtoQueTemNoEstoque.add(produto);
            }
        }
        return produtoQueTemNoEstoque;
    }
}
