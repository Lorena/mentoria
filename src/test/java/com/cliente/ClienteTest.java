package com.cliente;

import org.junit.Test;
import com.cliente.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClienteTest {

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteQuandoNaoExistirCpf() throws Exception {
     new Cliente(2, null, "Erica", "98999-9999", "erica@email.com", "Rua ABC, 123", null);
    }

    @Test
    public void deveCadastrarClienteComSucesso() throws Exception {
        int codigo = 1;
        String cpf = "123.456.789-00";
        String nome = "Teste";
        String telefone = "98999-9999";
        String email = "teste@email.com";
        String endereco = "Rua ABC, 123";
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180220");

        Cliente cliente = new Cliente(codigo, cpf, nome, telefone, email, endereco, dataCadastro);

        assertThat(cliente.getCodigo(), is(codigo));
}

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteSemPreencherUmContato() throws Exception{
        new Cliente(2, "136.707.026-01", "Erica", null, null, "Rua ABC, 123", null);
    }
}