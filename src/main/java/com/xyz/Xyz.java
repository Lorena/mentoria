package com.xyz;

import com.pedido.Pedido;

public class Xyz {

    private int qtdCilindroCheio;
    private String tipoGas;
    private Pedido pedido;

    public Xyz(int qtdCilindroCheio, String tipoGas, Pedido pedido) throws Exception {
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
        this.qtdCilindroCheio = qtdCilindroCheio;
        this.tipoGas = tipoGas;
        this.pedido = pedido;
    }
}
