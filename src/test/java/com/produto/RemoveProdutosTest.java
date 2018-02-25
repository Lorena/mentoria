package com.produto;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RemoveProdutosTest {

    @Test
    public void deveRemoverUmProdutoComSucesso() throws Exception {
        Produto produto1 = new Produto(1, "Nome1", 0, 1, 2, new SimpleDateFormat("yyyyMMdd").parse("20180118"));
        Produto produto2 = new Produto(2, "Nome2", 0, 1, 2, new SimpleDateFormat("yyyyMMdd").parse("20180118"));
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(produto1);
        produtos.add(produto2);

        RemoveProdutos removeProdutos = new RemoveProdutos(produtos);
        removeProdutos.removeProduto(2);

        assertThat(produtos.size(), is(1));
    }

    @Test(expected = Exception.class)
    public void retornaExceptionQuandoNaoRemoveProdutoPorErroDoJava() throws Exception {

        Produto produto2 = new Produto(1, "Nome1", 0, 1, 2, new SimpleDateFormat("yyyyMMdd").parse("20180118"));

        List<Produto> produtos = mock(ArrayList.class);
        Iterator<Produto> iterator = mock(Iterator.class);

        when(iterator.hasNext()).thenReturn(true);
        when(produtos.iterator()).thenReturn(iterator);
        when(produtos.get(eq(1))).thenReturn(produto2);

        when(produtos.remove(produto2)).thenReturn(false);

        RemoveProdutos removeProdutos = new RemoveProdutos(produtos);

        removeProdutos.removeProduto(1);
    }

    @Test(expected = Exception.class)
    public void retornaExceptionQuandoNaoEncontraProduto() throws Exception {

        Produto produto1 = new Produto(1, "Nome1", 0, 1, 2, new SimpleDateFormat("yyyyMMdd").parse("20180118"));
        Produto produto2 = new Produto(20, "Nome2", 0, 1, 2, new SimpleDateFormat("yyyyMMdd").parse("20180118"));

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(produto1);
        produtos.add(produto2);

        RemoveProdutos removeProdutos = new RemoveProdutos(produtos);

        removeProdutos.removeProduto(2);
    }


}