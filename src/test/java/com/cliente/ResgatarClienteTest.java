package com.cliente;

import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ResgatarClienteTest {
    private ResgatarCliente resgatarCliente;
    private CadastraCliente cadastraCliente = new CadastraCliente();

    @Test
    public void deveRetornarClientePorCpfInformado() throws Exception{
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180222");
        cadastraCliente.cadastraClientes( "123.456.789-00", "Teste1", "98999-9999", "teste1@email.com", null);
        cadastraCliente.cadastraClientes("123.456.789-01", "Teste2", "98999-9998", "teste2@email.com", null);

       resgatarCliente = new ResgatarCliente(cadastraCliente.getClientesCadastrados());

        Cliente clientesPorCpf = resgatarCliente.resgatarClientePeloCpf("123.456.789-00");

        assertThat(clientesPorCpf.getCpf(), is("123.456.789-00"));
    }
}