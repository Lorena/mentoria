package com.whiteGas;

import com.pedido.Pedido;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class WhiteGasTest {

    @Test
    public void deveCadastrarPedidoParaWhiteGasComSucesso() throws Exception {
        int qtdNovosCilindros = 1;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");;
        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180316");
        List<WhiteGas> pedidoList;

        WhiteGas whiteGas = new WhiteGas(qtdNovosCilindros, dataPedido, dataEnvioPedido);
        pedidoList = whiteGas.cadastraPedido(qtdNovosCilindros, dataPedido, dataEnvioPedido);

        assertThat(pedidoList.size(), is(1));
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeDataPedidoForDepoisDeQuintaFeira() throws Exception {
        int qtdNovosCilindros = 1;
        Date dataPedido = new Date();
        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180316");

        new WhiteGas(qtdNovosCilindros, dataPedido, dataEnvioPedido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeDataEnvioPedidoForAntesDeSextaFeira() throws Exception {
        int qtdNovosCilindros = 1;
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180308");
        Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180315");

        new WhiteGas(qtdNovosCilindros, dataPedido, dataEnvioPedido);
    }
}