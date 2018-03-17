package com.whiteGas;

import com.pedido.Pedido;

import java.util.Date;

public class WhiteGas {
    private Pedido pedido;
    private int qtdNovosCilindros;
    private Date dataPedido;

    public WhiteGas(Pedido pedido, int qtdNovosCilindros, Date dataPedido) {
        this.pedido = pedido;
        this.qtdNovosCilindros = qtdNovosCilindros;
        this.dataPedido = dataPedido;
    }


}
