package com.produto;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CadastraProdutoTest {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    public void deveCadastrarProdutoComSucesso() throws Exception {

        CadastraProduto cadastraProduto = new CadastraProduto(); //Arrange
        String codigo = "1";
        String nome = "Nome do Produto";
        double preco = 1.00;
        int quantidadeEstoque = 2;
        int estoqueMinima = 1;
        Date dataOntem = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        String mensagem = cadastraProduto.cadastrar(codigo, nome, preco, quantidadeEstoque, estoqueMinima, dataOntem); //Action

        assertThat(mensagem, is("Cadastrada com sucesso!!")); //Assert
    }

    @Test
    public void deveExistirCodigoQuandoForCadastrarOProduto() throws Exception {

        CadastraProduto cadastrarProduto = new CadastraProduto();
        String codigo = "1";

        Date dataOntem = new SimpleDateFormat("yyyyMMdd").parse("20180118");

        String mensagem = cadastrarProduto.cadastrar(codigo, null, 0, 0, 0, dataOntem);

        assertThat(mensagem, is("Cadastrada com sucesso!!"));

    }

    @Test
    public void naoDeveCadastrarProdutoQuandoNaoExistirCodigo() throws Exception {

        CadastraProduto cadastrarProduto = new CadastraProduto();

        String mensagem = cadastrarProduto.cadastrar(null, null, 0, 0, 0, null);

        assertThat(mensagem, is("Produto nao cadastrado"));
    }

    @Test
    public void naoDeveCadastrarProdutoQuandoADataForDepoisDoDiaAtual() throws Exception {

        Date dataFutura = new SimpleDateFormat("yyyyMMdd").parse("20180120");

        CadastraProduto cadastrarProduto = new CadastraProduto();

        String mensagem = cadastrarProduto.cadastrar("1", null, 0, 0, 0, dataFutura);

        assertThat(mensagem, is("Produto nao cadastrado"));

    }
}