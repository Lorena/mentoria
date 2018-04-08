package com.xyz;

import com.pedido.Pedido;
import com.whiteGas.WhiteGas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Xyz {

    private int qtdCilindroGasHelio;
    private int qtdCilindroMonoxido;
    private int qtdCilindroDioxido;
    private List<Pedido> pedidoList = new ArrayList<>();
    private int contadorPedidos = 0;

    public Xyz(int qtdCilindroGasHelio, int qtdCilindroMonoxido, int qtdCilindroDioxido)
            throws  Exception{
        validaEstoqueDeCilindros(qtdCilindroDioxido, qtdCilindroMonoxido, qtdCilindroGasHelio);
        this.qtdCilindroGasHelio = qtdCilindroGasHelio;
        this.qtdCilindroMonoxido = qtdCilindroMonoxido;
        this.qtdCilindroDioxido = qtdCilindroDioxido;
    }

    public List<Pedido> cadastraPedido(int qtdCilindroDioxido, int qtdCilindroGasHelio, int qtdCilindroMonoxido, Pedido pedido) throws Exception {
        validaEstoqueDeCilindros(qtdCilindroDioxido, qtdCilindroMonoxido, qtdCilindroGasHelio);
        pedidoList.add(pedido);
        contadorPedidos++;
        return pedidoList;
    }

    private void validaEstoqueDeCilindros(int qtdCilindroDioxido, int qtdCilindroMonoxido, int qtdCilindroGasHelio)
    throws Exception{
        validaSePossuiDezCilindrosCheios(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        validaSeExisteCilindroDeDioxidoDisponivel(qtdCilindroDioxido);
        validaSeExisteCilindroDeMonoxidoDisponivel(qtdCilindroMonoxido);
        validaSeExisteCilindroDeGasHelioDisponivel(qtdCilindroGasHelio);
    }

    private void validaSePossuiDezCilindrosCheios(int qtdCilindroGasHelio, int qtdCilindroMonoxido, int qtdCilindroDioxido) throws Exception {
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
    }

    private void validaSeExisteCilindroDeGasHelioDisponivel(int qtdCilindroGasHelio) throws Exception {
        if(qtdCilindroGasHelio == 0){
            throw new Exception("Não possuímos cilindros de Gás Hélio disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    private void validaSeExisteCilindroDeMonoxidoDisponivel(int qtdCilindroMonoxido) throws Exception {
        if(qtdCilindroMonoxido == 0){
            throw new Exception("Não possuímos cilindros de Monóxido de Carbono disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }

    private void validaSeExisteCilindroDeDioxidoDisponivel(int qtdCilindroDioxido) throws Exception {
        if(qtdCilindroDioxido == 0){
            throw new Exception("Não possuímos cilindros de Dióxido de Carbono disponível no momento. Na semana seguinte iremos enviá-lo.");
        }
    }
}