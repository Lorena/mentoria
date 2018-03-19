package com.xpto;

import com.cliente.Cliente;
import com.pedido.Pedido;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class XptoTest {

    @Test
    public void deveCadastrarClienteEPedido() throws Exception {
        Date dataNascimento = new SimpleDateFormat("yyyyMMdd").parse("19970614");
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Cliente cliente = new Cliente("123.456.789-00", "Erica", "9 9988-9988", "erica.viana@email.com", dataNascimento, pedido);

        Xpto xpto = new Xpto();

        //O que vc acha de renomear o nome desse método para cadastraClienteComPedidoDesejado(cliente)?
        List<Cliente> clienteList = xpto.cadastraClienteEPedido(cliente);

        assertThat(clienteList.size(), is(1));
    }

}