package com.produto;

import com.produto.model.Produto;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProdutosTest {

    private Produtos produtos;

    @Before
    public void setUp() throws Exception {
        produtos = new Produtos();
    }

    @Test
    public void deveCadastrarMultiplosProdutos() throws Exception {

        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        List<Produto> produtoList = produtos.cadastraProdutos(1, "Nome1", 0, 1, 2, dataCadastro);
        assertThat(produtoList.size(), is(1));

        produtoList = produtos.cadastraProdutos(2, "Nome2", 0, 1, 2, dataCadastro);
        assertThat(produtoList.size(), is(2));
    }

    @Test
    public void devePegarTodosOsProdutosCadastradosQueTemNoEstoque() throws Exception {

        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        produtos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        produtos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        List<Produto> produtosTemNoEstoque = produtos.getProdutosTemNoEstoque();

        assertThat(produtosTemNoEstoque.size(), is(1));
    }


    @Test
    public void devePegarProdutoPeloNome() throws Exception {

        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        produtos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        produtos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        List<Produto> produtosPorNome = produtos.getProdutosPorNome("Nome2");

        assertThat(produtosPorNome.size(), is(1));
        assertThat(produtosPorNome.get(0).getNome(), is("Nome2"));

    }


    @Test
    public void devePegarProdutoCadastradoNaDataInformada() throws Exception {
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        produtos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        produtos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        List<Produto> produtosPorData = produtos.getProdutosPorData(dataCadastro);

        assertThat(produtosPorData.size(), is(2));
    }

    @Test
    public void devePegarProdutoComPrecoMaiorDoQuePrecoInformado() throws Exception {
        //Erica fazer o teste e implementar o método para fazer o teste passar.

    }
}