package com.xyz;

import com.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Xyz {

    private int qtdCilindroGasHelio;
    private int qtdCilindroMonoxido;
    private int qtdCilindroDioxido;
    private List<Pedido> pedidoList = new ArrayList<>();
    private int contadorPedidos = 0;

    public Xyz(int qtdCilindroGasHelio, int qtdCilindroMonoxido, int qtdCilindroDioxido)
            throws  Exception{
        validaSePossuiDezCilindrosCheios(qtdCilindroDioxido, qtdCilindroGasHelio, qtdCilindroMonoxido);
        this.qtdCilindroGasHelio = qtdCilindroGasHelio;
        this.qtdCilindroMonoxido = qtdCilindroMonoxido;
        this.qtdCilindroDioxido = qtdCilindroDioxido;
    }

    public List<Pedido> cadastraPedido(Pedido pedido) throws Exception {
        validaEstoqueDeCilindros(pedido);
        pedidoList.add(pedido);
        contadorPedidos++; //para que esse contador? para saber a quantidade de pedidos é só ver o tamanho da lista
        return pedidoList;
    }

    private void validaEstoqueDeCilindros(Pedido pedido) throws Exception{
        if(pedido.getGas().equals("Dióxido de Carbono")) {
            validaSeExisteCilindroDeDioxidoDisponivel();
        }else if(pedido.getGas().equals("Monóxido de Carbono")) {
           validaSeExisteCilindroDeMonoxidoDisponivel();
        }else if(pedido.getGas().equals("Gás Hélio")) {
            validaSeExisteCilindroDeGasHelioDisponivel();
        }
    }

    private void validaSePossuiDezCilindrosCheios(int qtdCilindroDioxido, int qtdCilindroGasHelio, int qtdCilindroMonoxido) throws Exception {
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
    }

    private void validaSeExisteCilindroDeGasHelioDisponivel() throws Exception {
        if(this.qtdCilindroGasHelio == 0){
            throw new Exception("Não possuímos cilindros de Gás Hélio disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    private void validaSeExisteCilindroDeMonoxidoDisponivel() throws Exception {
        if(this.qtdCilindroMonoxido == 0){
            throw new Exception("Não possuímos cilindros de Monóxido de Carbono disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    private void validaSeExisteCilindroDeDioxidoDisponivel() throws Exception {
        if(this.qtdCilindroDioxido == 0){
            throw new Exception("Não possuímos cilindros de Dióxido de Carbono disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }
}