package com.pedido;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CadastraPedidoTest {

    private CadastraPedido cadastraPedido;

    @Before
    public void setUp() throws Exception {
        cadastraPedido = new CadastraPedido();
    }

    @Test
    public void deveCadastrarMultiplosProdutos() throws Exception {
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");
        Date dataPedido = new Date();

        List<Pedido> pedidoList =  cadastraPedido.cadastraPedido("Monóxido de Carbono", 5.0, "Rua ABC", "Rua ABC", dataEntrega, dataPedido);
        pedidoList = cadastraPedido.cadastraPedido("Dióxido de Carbono", 5.0, "Rua EFG", "Rua EFG", dataEntrega, dataPedido);
        pedidoList = cadastraPedido.cadastraPedido("Gás Hélio", 5.0, "Rua EFG", "Rua ABC", dataEntrega, dataPedido);

        assertThat(pedidoList.size(), is(3));
    }

}