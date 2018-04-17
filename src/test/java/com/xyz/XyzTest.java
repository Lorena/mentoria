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
        pedidoList = xyz.cadastraPedido(pedido);

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
    public void deveRetornarErroSeNaoHouverCilindroParaGasHelio() throws Exception {
        int qtdCilindroGasHelio = 0;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");

        Pedido pedido = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        xyz.cadastraPedido(pedido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverCilindroParaMonoxido() throws Exception {
        int qtdCilindroGasHelio = 20;
        int qtdCilindroMonoxido = 0;
        int qtdCilindroDioxido = 10;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");

        Pedido pedido = new Pedido("Monóxido de Carbono", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        xyz.cadastraPedido(pedido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverCilindroParaDioxido() throws Exception {
        int qtdCilindroGasHelio = 20;
        int qtdCilindroMonoxido = 10;
        int qtdCilindroDioxido = 0;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");

        Pedido pedido = new Pedido("Dióxido de Carbono", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        xyz.cadastraPedido(pedido);
    }

    @Test
    public void deveEnviarPedidoParaWhiteGasQuandoNaoHouverGasPedido() throws Exception {
        int qtdCilindroGasHelio = 0;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180419");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180504");

        Pedido pedido = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        try{
            xyz.cadastraPedido(pedido);
        } catch (Exception e){System.out.print("Capturou a Exceção");}

        List<Pedido> pedidosWhiteGas = xyz.enviarPedidoParaWhiteGas();

        assertThat(pedidosWhiteGas.get(0).getGas(), is("Gás Hélio"));
        assertThat(pedidosWhiteGas.get(0).getQuantidadeMmCubicos(), is(5.0));
    }

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
            xyz.cadastraPedido(pedido);

            Pedido pedido2 = new Pedido("Gás Hélio", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
            xyz.cadastraPedido(pedido2);

           Pedido pedido3 = new Pedido("Dióxido de Carbono", 5, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
           pedidoList = xyz.cadastraPedido(pedido3);

            assertThat(pedidoList.size(), is(3));
       }
}