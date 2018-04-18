package com.cliente;

import com.pedido.Pedido;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClienteTest {

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteQuandoNaoExistirCpf() throws Exception {
     new Cliente(null, "Erica", "98999-9999", "erica@email.com", null, null);
    }

    @Test
    public void deveCadastrarClienteComSucesso() throws Exception {
        String cpf = "123.456.789-00";
        String nome = "Teste";
        String telefone = "98999-9999";
        String email = "teste@email.com";
        Date dataNascimento = new SimpleDateFormat("yyyyMMdd").parse("20180220");

        Cliente cliente = new Cliente(cpf, nome, telefone, email, dataNascimento, null);

        assertThat(cliente.getCpf(), is(cpf));
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteSemPreencherUmContato() throws Exception{
        new Cliente("136.707.026-01", "Erica", null, null, null,
                null);
    }

    @Test
    public void validaSeRecebeuPedidoComSucesso() throws Exception {
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");
        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        Cliente cliente = new Cliente("136.707.026-01", "Erica", "3333-9999",null, null, pedido);

        assertTrue(cliente.receberPedido(pedido));
    }

    @Test
    public void deveRetornarFalsoQuandoReceberOPedidoErrado() throws Exception {
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");
        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        Cliente cliente = new Cliente("136.707.026-01", "Erica", "3333-9999",null, null, pedido);

        Pedido pedidoErrado = new Pedido("Monóxido de Carbono", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        assertFalse(cliente.receberPedido(pedidoErrado));
    }
}