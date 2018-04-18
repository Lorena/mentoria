package com;

import com.cliente.Cliente;
import com.pedido.Pedido;
import com.whiteGas.WhiteGas;
import com.xpto.Xpto;
import com.xyz.Xyz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws Exception {

        umClienteSolicitaGasHelioParaXptoEntaoRecebeComSucessoDeXyz();
//        umClienteSolicitaGasHelioParaXptoMasXyzNaoTemGasHelio();
//        multiplosClientesSolicitamGasHelioParaXptoEntaoRecebemComSucessoDeXyz();

    }

    private static void umClienteSolicitaGasHelioParaXptoEntaoRecebeComSucessoDeXyz() throws Exception {
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");

        Pedido pedido = new Pedido("Gás Hélio", 1.0, "Rua lala", "Rua lala", dataPedido, dataEntrega);
        Date dataNascimento = null;
        Cliente lorena = new Cliente("012.213.123-32", "Lorena", "323232", "lores@lorena.com", dataNascimento, pedido);

        Xpto xpto = new Xpto();
        List<Cliente> clientes = xpto.agendarPedidoDoClienteComUmaSemanaDeAntecedencia(lorena);

        Xyz xyz = new Xyz(10, 10, 10);
        xyz.cadastraPedido(clientes.get(0).getPedido());
        Pedido pedidoAEntregar = xyz.entregaPedidoParaCliente();

        boolean pedicoComSucesso = lorena.receberPedido(pedidoAEntregar);

        if(pedicoComSucesso) {
            System.out.println("Pedido solicitado e recebido com suceesso imediatamente");
        }
    }

    private static void multiplosClientesSolicitamGasHelioParaXptoEntaoRecebemComSucessoDeXyz() {
        //Fazer
    }

    private static void umClienteSolicitaGasHelioParaXptoMasXyzNaoTemGasHelio() throws Exception {
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180212");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180413");

        Pedido pedido = new Pedido("Gás Hélio", 1.0, "Rua lala", "Rua lala", dataPedido, dataEntrega);
        Date dataNascimento = null;
        Cliente lorena = new Cliente("012.213.123-32", "Lorena", "323232", "lores@lorena.com", dataNascimento, pedido);

        Xpto xpto = new Xpto();
        List<Cliente> clientes = xpto.agendarPedidoDoClienteComUmaSemanaDeAntecedencia(lorena);

        Xyz xyz = new Xyz(0, 10, 10);
        xyz.cadastraPedido(clientes.get(0).getPedido());

        try {
            xyz.entregaPedidoParaCliente();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        WhiteGas whiteGas = new WhiteGas();
        whiteGas.cadastraPedidos(xyz.enviarPedidoParaWhiteGas().get(0), dataPedido);

        List<Pedido> listaDePedidosDeWitheGas = whiteGas.entregaPedidos();
        xyz.recebePedidoDeWhiteGas(listaDePedidosDeWitheGas);

        Pedido pedidoDeXyz = xyz.entregaPedidoParaCliente();

        boolean pedidoComSucesso = lorena.receberPedido(pedidoDeXyz);

        if(pedidoComSucesso) {
            System.out.println("Pedido solicitado e recebido com suceesso imediatamente");
        }
    }
}
