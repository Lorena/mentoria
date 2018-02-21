package com.cliente;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CadastraClienteTest {

    private CadastraCliente cadastraCliente;

    @Before
    public void setUp() throws Exception {
        cadastraCliente = new CadastraCliente();
    }


@Test
    public void deveCadastrarMultiplosClientes() throws Exception{
    Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180220");

    List<Cliente> clienteList = cadastraCliente.cadastraClientes(1, "123.456.789-00", "Teste1", "98999-9999", "teste1@email.com", "Rua teste", dataCadastro);
    assertThat(clienteList.size(), is(1));

    clienteList = cadastraCliente.cadastraClientes(2, "123.456.789-01", "Teste2", "98899-9999", "teste2@email.com", "Rua teste2", dataCadastro);
    assertThat(clienteList.size(), is(2));
    }
}