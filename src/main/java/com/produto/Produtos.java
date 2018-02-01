package com.produto;

import com.produto.model.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produtos {

    private List<Produto> produtos = new ArrayList<Produto>();

    public List<Produto> cadastraProdutos(int codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinima, Date dataCadastro) throws Exception {
        CadastraProduto cadastraProduto = new CadastraProduto();

         produtos.add(cadastraProduto.cadastrar(codigo, nome, preco, quantidadeEstoque, estoqueMinima, dataCadastro));

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
            List<Produto> produtoPesquisadoPorNome = new ArrayList<Produto>();
            for(Produto produto : produtos){
                if(produto.getNome().equals(nome)){
                    produtoPesquisadoPorNome.add(produto);
                }
            }
        return produtoPesquisadoPorNome;
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

    public List<Produto> getProdutosComPrecoMaiorDoQuePrecoInformado(int i) {

        return null;
    }
}