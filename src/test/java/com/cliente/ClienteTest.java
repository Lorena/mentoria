package com.cliente;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClienteTest {

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteQuandoNaoExistirCpf() throws Exception {
     new Cliente(null, "Erica", "98999-9999", "erica@email.com", null);
    }

    @Test
    public void deveCadastrarClienteComSucesso() throws Exception {
        int codigo = 1;
        String cpf = "123.456.789-00";
        String nome = "Teste";
        String telefone = "98999-9999";
        String email = "teste@email.com";
        Date dataNascimento = new SimpleDateFormat("yyyyMMdd").parse("20180220");

        Cliente cliente = new Cliente(cpf, nome, telefone, email, dataNascimento);

        assertThat(cliente.getCpf(), is(cpf));
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteSemPreencherUmContato() throws Exception{
        new Cliente("136.707.026-01", "Erica", null, null, null
        );
    }
}