package com.whiteGas;

import com.pedido.Pedido;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class WhiteGasTest {

    @Test
    public void deveRetornarVerdadeiroAoIniciarWhiteGas() throws Exception {
        String gas = "Gás Hélio";
        int qtdCilindros = 10;
        WhiteGas whiteGas = new WhiteGas(gas, qtdCilindros);

        assertThat(whiteGas, is(not(nullValue())));
    }

    @Test
    public void deveCadastrarPedidoParaWhiteGasComSucesso() throws Exception {
        String gas = "Gás Hélio";
        int qtdCilindros = 10;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180419");
        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180427");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180504");
        Pedido pedido = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        List<Pedido> pedidoList;

        WhiteGas whiteGas = new WhiteGas(gas, qtdCilindros);
        pedidoList = whiteGas.cadastraPedido(pedido, dataPedido, dataEnvioPedido);

        assertThat(pedidoList.size(), is(1));
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeDataPedidoForDepoisDeQuintaFeira() throws Exception {
        String gas = "Gás Hélio";
        int qtdCilindros = 10;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180411");
        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180427");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180504");
        Pedido pedido = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        List<Pedido> pedidoList;

        WhiteGas whiteGas = new WhiteGas(gas, qtdCilindros);
        pedidoList = whiteGas.cadastraPedido(pedido, dataPedido, dataEnvioPedido);
    }

//    @Test(expected = Exception.class)
//    public void deveRetornarErroSeDataEnvioPedidoForAntesDeSextaFeira() throws Exception {
//        int qtdNovosCilindros = 1;
//        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180308");
//        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180315");
//
//        //new WhiteGas(qtdNovosCilindros, dataPedido, dataEnvioPedido);
//    }
}