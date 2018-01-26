package com.produto;

import com.produto.model.Produto;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CadastraProdutoTest {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    public void deveCadastrarProdutoComSucesso() throws Exception {

        CadastraProduto cadastraProduto = new CadastraProduto(); //Arrange
        int codigo = 1;
        String nome = "Nome do Produto";
        double preco = 1.00;
        int quantidadeEstoque = 2;
        int estoqueMinima = 1;
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180118");

       Produto produto = cadastraProduto.cadastrar(codigo, nome, preco, quantidadeEstoque, estoqueMinima, dataCadastro); //Action

        assertThat(produto.getCodigo(), is(codigo)); //Assert
        assertThat(produto.getNome(), is(nome));
        assertThat(produto.getPreco(), is(preco));
        assertThat(produto.getQuantidadeEstoque(), is(quantidadeEstoque));
        assertThat(produto.getEstoqueMinima(), is(estoqueMinima));
        assertThat(produto.getDataCadastro(), is(dataCadastro));
    }

    @Test
    public void deveExistirCodigoQuandoForCadastrarOProduto() throws Exception {

        CadastraProduto cadastrarProduto = new CadastraProduto();
        int codigo = 1;

        Date dataOntem = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        Produto produto = cadastrarProduto.cadastrar(codigo, null, 0, 0, 0, dataOntem);

        assertThat(produto.getCodigo(), is(codigo));
    }

    @Test (expected = Exception.class)
    public void naoDeveCadastrarProdutoQuandoNaoExistirCodigo() throws Exception {

        CadastraProduto cadastrarProduto = new CadastraProduto();

       cadastrarProduto.cadastrar(0, null, 0, 0, 0, null);
    }

    @Test (expected = Exception.class)
    public void naoDeveCadastrarProdutoQuandoADataForDepoisDoDiaAtual() throws Exception {

        Date dataHoje = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataHoje);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date amanha = calendar.getTime();

        CadastraProduto cadastrarProduto = new CadastraProduto();

        cadastrarProduto.cadastrar(1, null, 0, 0, 0, amanha);
    }
}