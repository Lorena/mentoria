package com.xyz;

import com.pedido.Pedido;
import com.whiteGas.WhiteGas;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class XyzTest {

    @Test
    public void cadastraPedidoParaXyzComSucesso() throws Exception {
        int qtdCilindroGasHelio = 10;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido, qtdCilindroCheio, pedido);

        assertThat(xyz, is(not(nullValue())));
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverDezCilindrosCheios() throws Exception {
        int qtdCilindroGasHelio = 1;
        int qtdCilindroMonoxido = 1;
        int qtdCilindroDioxido = 1;
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido, qtdCilindroCheio, pedido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverCilindroParaGasPedidoEPedirParaWhiteGas() throws Exception {
        int qtdCilindroGasHelio = 0;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        int qtdNovosCilindros = 1;
        String gas = "Gás Hélio";
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido(gas, 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido, qtdCilindroCheio, pedido);

        WhiteGas whiteGas = new WhiteGas(pedido,  qtdNovosCilindros, dataPedido);
    }

}