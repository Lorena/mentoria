package com.xyz;

import com.pedido.Pedido;
import com.whiteGas.WhiteGas;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class XyzTest {

    @Test
    public void deveRetornarVerdadeiroAoIniciarXyz() throws Exception {
        int qtdCilindroGasHelio = 10;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;

        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);

        assertThat(xyz, is(not(nullValue())));
    }

    @Test
    public void cadastraPedidoParaXyzComSucesso() throws Exception {
        int qtdCilindroGasHelio = 10;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        List<Pedido> pedidoList;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");

        Pedido pedido = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        pedidoList = xyz.cadastraPedido(qtdCilindroDioxido, qtdCilindroGasHelio, qtdCilindroMonoxido, pedido);

        assertThat(pedidoList.size(), is(1));
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverDezCilindrosCheios() throws Exception {
        int qtdCilindroGasHelio = 1;
        int qtdCilindroMonoxido = 1;
        int qtdCilindroDioxido = 1;

        new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverCilindroParaGasPedido() throws Exception {
        int qtdCilindroGasHelio = 0;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;

        new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
    }

//    @Test
//    public void deveEnviarPedidoParaWhiteGasQuandoNaoHouverGasPedido() throws Exception {
//        int qtdCilindroGasHelio = 0;
//        int qtdCilindroMonoxido = 20;
//        int qtdCilindroDioxido = 10;
//        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180419");
//        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180427");
//        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180504");
//
//        Pedido pedido = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
//        new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
//
//        int qtdNovosCilindros = 10;
//
//        WhiteGas whiteGas = new WhiteGas(qtdNovosCilindros,dataPedido, dataEnvioPedido);
//        whiteGas.cadastraPedido(qtdNovosCilindros, dataPedido, dataEnvioPedido, pedido);
//    }

    @Test
    public void deveRetornarQuantosPedidosForamRecebidos() throws Exception {
            int qtdCilindroGasHelio = 10;
            int qtdCilindroMonoxido = 20;
            int qtdCilindroDioxido = 10;
            List<Pedido> pedidoList;
            Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
            Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");
            Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);

            Pedido pedido = new Pedido("Monóxido de Carbono", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
            pedidoList = xyz.cadastraPedido(qtdCilindroDioxido, qtdCilindroGasHelio, qtdCilindroMonoxido, pedido);

            int qtdCilindroGasHelio2 = 20;
            int qtdCilindroMonoxido2 = 5;
            int qtdCilindroDioxido2 = 15;
            Pedido pedido2 = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
            pedidoList = xyz.cadastraPedido(qtdCilindroDioxido2, qtdCilindroGasHelio2, qtdCilindroMonoxido2, pedido2);

            int qtdCilindroGasHelio3 = 15;
            int qtdCilindroMonoxido3 = 5;
            int qtdCilindroDioxido3 = 20;
            Pedido pedido3 = new Pedido("Dióxido de Carbono", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
            pedidoList = xyz.cadastraPedido(qtdCilindroDioxido3, qtdCilindroGasHelio3, qtdCilindroMonoxido3, pedido3);

            assertThat(pedidoList.size(), is(3));
       }

}