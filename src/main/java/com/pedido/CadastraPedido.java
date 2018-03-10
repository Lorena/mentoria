package com.pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastraPedido {

    private List<Pedido> pedidoList = new ArrayList<Pedido>();

    public List<Pedido> cadastraPedido(String gas, double quantidadeEmMmCubicos, String enderecoEntrega, String enderecoRecuperacao, Date dataEntrega, Date dataPedido)
            throws Exception {
        pedidoList.add(new Pedido(gas, quantidadeEmMmCubicos, enderecoEntrega, enderecoRecuperacao, dataEntrega, dataPedido));
        return pedidoList;
    }
}