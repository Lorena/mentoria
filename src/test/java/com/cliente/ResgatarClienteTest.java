package com.cliente;

import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ResgatarClienteTest {

    private CadastraCliente cadastraCliente;
    private  ResgatarCliente resgatarCliente;
    @Before
    public void setUp() throws Exception {
        cadastraCliente = new CadastraCliente();
        resgatarCliente = new ResgatarCliente();
    }

    @Test
    public void deveRetornarClienteComCpfInformado() throws Exception{
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180222");
        cadastraCliente.cadastraClientes(1, "123.456.789-00", "Teste1", "98999-9999", "teste1@email.com", "Rua teste", dataCadastro);

        List<Cliente> clientesPorCpf = resgatarCliente.resgatarClientePeloCpf("123.456.789-00");
        assertThat(clientesPorCpf.size(), is(1));
    }
}