package com.produto;

import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CadastraProdutosTest {

    private CadastraProdutos cadastraProdutos;

    @Before
    public void setUp() throws Exception {
        cadastraProdutos = new CadastraProdutos();
    }

    @Test
    public void deveCadastrarMultiplosProdutos() throws Exception {

        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        List<Produto> produtoList = cadastraProdutos.cadastraProdutos(1, "Nome1", 0, 1, 2, dataCadastro);
        assertThat(produtoList.size(), is(1));

        produtoList = cadastraProdutos.cadastraProdutos(2, "Nome2", 0, 1, 2, dataCadastro);
        assertThat(produtoList.size(), is(2));
    }
}