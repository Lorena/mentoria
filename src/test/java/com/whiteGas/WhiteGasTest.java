package com.whiteGas;

import com.pedido.Pedido;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class WhiteGasTest {

    @Test
    public void deveCadastrarPedidoParaWhiteGasComSucesso() throws Exception {
        int qtdNovosCilindros = 1;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);

        WhiteGas whiteGas = new WhiteGas(pedido, qtdNovosCilindros, dataPedido);
        assertThat(whiteGas, is(not(nullValue())));
    }

}