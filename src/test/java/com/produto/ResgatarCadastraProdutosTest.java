package com.produto;

import com.produto.model.Produto;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ResgatarCadastraProdutosTest {
    private ResgatarProdutos resgatarProdutos;
    private CadastraProdutos cadastraProdutos = new CadastraProdutos();

    @Test
    public void devePegarProdutoComPrecoMaiorDoQuePrecoInformado() throws Exception {
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        cadastraProdutos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        cadastraProdutos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        resgatarProdutos = new ResgatarProdutos(cadastraProdutos.getProdutosCadastrados());
        List<Produto> produtosPrecoMaior = resgatarProdutos.getProdutosComPrecoMaiorDoQuePrecoInformado(100);

        assertThat(produtosPrecoMaior.size(), is(1));
    }

    @Test
    public void devePegarProdutoCadastradoNaDataInformada() throws Exception {
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        cadastraProdutos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        cadastraProdutos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        resgatarProdutos = new ResgatarProdutos(cadastraProdutos.getProdutosCadastrados());
        List<Produto> produtosPorData = resgatarProdutos.getProdutosPorData(dataCadastro);

        assertThat(produtosPorData.size(), is(2));
    }

    @Test
    public void devePegarProdutoPeloNome() throws Exception {

        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        cadastraProdutos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        cadastraProdutos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        resgatarProdutos = new ResgatarProdutos(cadastraProdutos.getProdutosCadastrados());
        List<Produto> produtosPorNome = resgatarProdutos.getProdutosPorNome("Nome2");

        assertThat(produtosPorNome.size(), is(1));
        assertThat(produtosPorNome.get(0).getNome(), is("Nome2"));

    }

    @Test
    public void devePegarTodosOsProdutosCadastradosQueTemNoEstoque() throws Exception {

        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");
        cadastraProdutos.cadastraProdutos(1, "Nome1", 100, 1, 2, dataCadastro);
        cadastraProdutos.cadastraProdutos(2, "Nome2", 101, 0, 2, dataCadastro);

        resgatarProdutos = new ResgatarProdutos(cadastraProdutos.getProdutosCadastrados());
        List<Produto> produtosTemNoEstoque = resgatarProdutos.getProdutosTemNoEstoque();

        assertThat(produtosTemNoEstoque.size(), is(1));
    }
}