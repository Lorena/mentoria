package com.xyz;

import com.pedido.Pedido;

public class Xyz {

    private int qtdCilindroCheio;
    private Pedido pedido;

    public Xyz(int qtdCilindroCheio, Pedido pedido) throws Exception {
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
        this.qtdCilindroCheio = qtdCilindroCheio;
        this.pedido = pedido;
    }
}
