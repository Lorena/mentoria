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
        int qtdCilindroCheio = 10;
        String tipoGas = null;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroCheio, tipoGas, pedido);

        assertThat(xyz, is(not(nullValue())));
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverDezCilindrosCheios() throws Exception {
        int qtdCilindroCheio = 5;
        String tipoGas = "Gás Hélio";
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroCheio, tipoGas, pedido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverCilindroParaGasPedidoEPedirParaWhiteGas() throws Exception {
        int qtdCilindroCheio = 10;
        int qtdNovosCilindros = 1;
        String gas = "Gás Hélio";
        String tipoGas = gas;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido(gas, 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroCheio, tipoGas, pedido);

        WhiteGas whiteGas = new WhiteGas(pedido,  qtdNovosCilindros, dataPedido);
    }

}