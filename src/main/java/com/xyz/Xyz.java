package com.xyz;

import com.pedido.Pedido;

public class Xyz {

    private int qtdCilindroGasHelio;
    private int qtdCilindroMonoxido;
    private int qtdCilindroDioxido;
    private int qtdCilindroCheio;
    private Pedido pedido;

    public Xyz(int qtdCilindroGasHelio, int qtdCilindroMonoxido, int qtdCilindroDioxido, int qtdCilindroCheio, Pedido pedido)
            throws  Exception{
        validaSePossuiDezCilindrosCheios(qtdCilindroCheio);
        this.qtdCilindroGasHelio = qtdCilindroGasHelio;
        this.qtdCilindroMonoxido = qtdCilindroMonoxido;
        this.qtdCilindroDioxido = qtdCilindroDioxido;
        this.qtdCilindroCheio = qtdCilindroCheio;
        this.pedido = pedido;
    }

    private void validaSePossuiDezCilindrosCheios(int qtdCilindroCheio) throws Exception {
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
    }

}
