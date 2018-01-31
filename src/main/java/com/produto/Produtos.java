package com.produto;

import com.produto.model.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produtos {

    private List<Produto> produtos = new ArrayList<Produto>();

    public List<Produto> cadastraProdutos(int codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinima, Date dataCadastro) throws Exception {
        CadastraProduto cadastraProduto = new CadastraProduto();

        //Erica implementar o método para o teste passar

        return produtos;
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

        public List<Produto> getProdutosPorNome(String nome) {

        //Erica Implementar o método para o teste passar

        return null;
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
}