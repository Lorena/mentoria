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
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class XyzTest {

    @Test
    public void cadastraPedidoParaXyzComSucesso() throws Exception {
        int qtdCilindroGasHelio = 10;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180310");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");
        List<Xyz> pedidoList = new ArrayList<>();

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

       Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
       pedidoList = xyz.cadastraPedido(pedido, qtdCilindroDioxido, qtdCilindroGasHelio, qtdCilindroMonoxido);

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
}