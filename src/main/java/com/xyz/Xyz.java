package com.xyz;

import com.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Xyz {

    private int qtdCilindroGasHelio;
    private int qtdCilindroMonoxido;
    private int qtdCilindroDioxido;
    private Pedido pedidoAtual;
    private List<Pedido> pedidoList = new ArrayList<>();
    private List<Pedido> pedidoListWhiteGas = new ArrayList<>();

    public Xyz(int qtdCilindroGasHelio, int qtdCilindroMonoxido, int qtdCilindroDioxido)
            throws  Exception{
        validaSePossuiDezCilindrosCheios(qtdCilindroDioxido, qtdCilindroGasHelio, qtdCilindroMonoxido);
        this.qtdCilindroGasHelio = qtdCilindroGasHelio;
        this.qtdCilindroMonoxido = qtdCilindroMonoxido;
        this.qtdCilindroDioxido = qtdCilindroDioxido;
    }

    public List<Pedido> cadastraPedido(Pedido pedido) throws Exception {
//        validaEstoqueDeCilindros(pedido); //remover futuramente
        pedidoList.add(pedido);
        this.pedidoAtual = pedido;
        return pedidoList;
    }

    public Pedido entregaPedidoParaCliente() throws Exception {
        validaEstoqueDeCilindros(this.pedidoAtual);
        return this.pedidoAtual;
    }

    private void validaEstoqueDeCilindros(Pedido pedido) throws Exception{
        if(pedido.getGas().equals("Dióxido de Carbono")) {
            validaSeExisteCilindroDeDioxidoDisponivel(pedido);
        }else if(pedido.getGas().equals("Monóxido de Carbono")) {
           validaSeExisteCilindroDeMonoxidoDisponivel(pedido);
        }else if(pedido.getGas().equals("Gás Hélio")) {
            validaSeExisteCilindroDeGasHelioDisponivel(pedido);
        }
    }

    private void validaSePossuiDezCilindrosCheios(int qtdCilindroDioxido, int qtdCilindroGasHelio, int qtdCilindroMonoxido) throws Exception {
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
    }

    private void validaSeExisteCilindroDeGasHelioDisponivel(Pedido pedido) throws Exception {
        if(this.qtdCilindroGasHelio == 0){
            pedidoListWhiteGas.add(new Pedido(pedido.getGas(), pedido.getQuantidadeMmCubicos()));
            throw new Exception("Não possuímos cilindros de Gás Hélio disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    private void validaSeExisteCilindroDeMonoxidoDisponivel(Pedido pedido) throws Exception {
        if(this.qtdCilindroMonoxido == 0){
            pedidoListWhiteGas.add(new Pedido(pedido.getGas(), pedido.getQuantidadeMmCubicos()));
            throw new Exception("Não possuímos cilindros de Monóxido de Carbono disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    private void validaSeExisteCilindroDeDioxidoDisponivel(Pedido pedido) throws Exception {
        if(this.qtdCilindroDioxido == 0){
            pedidoListWhiteGas.add(new Pedido(pedido.getGas(), pedido.getQuantidadeMmCubicos()));
            throw new Exception("Não possuímos cilindros de Dióxido de Carbono disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    public List<Pedido> enviarPedidoParaWhiteGas() {
        return pedidoListWhiteGas;
    }

    public void recebePedidoDeWhiteGas(List<Pedido> listaDePedidosDeWitheGas) {
        //fazer
    }
}