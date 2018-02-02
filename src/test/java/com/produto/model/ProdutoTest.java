package com.produto.model;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProdutoTest {

    @Test(expected = Exception.class)
    public void naoDeveCadastrarProdutoQuandoADataForDepoisDoDiaAtual() throws Exception {

        Date dataHoje = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataHoje);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date amanha = calendar.getTime();

        new Produto(1, null, 0, 0, 0, amanha);
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarProdutoQuandoNaoExistirCodigo() throws Exception {
        new Produto(0, null, 0, 0, 0, null);
    }

    @Test
    public void deveExistirCodigoQuandoForCadastrarOProduto() throws Exception {
        int codigo = 1;

        Date dataOntem = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        Produto produto = new Produto(codigo, null, 0, 0, 0, dataOntem);

        assertThat(produto.getCodigo(), is(codigo));
    }

    @Test
    public void deveCadastrarProdutoComSucesso() throws Exception {
        int codigo = 1;
        String nome = "Nome do Produto";
        double preco = 1.00;
        int quantidadeEstoque = 2;
        int estoqueMinima = 1;
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        Produto produto = new Produto(codigo, nome, preco, quantidadeEstoque, estoqueMinima, dataCadastro); //Action

        assertThat(produto.getCodigo(), is(codigo)); //Assert
    }
}