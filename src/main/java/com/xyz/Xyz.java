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
        validaEstoqueDeCilindros(qtdCilindroCheio, qtdCilindroDioxido, qtdCilindroMonoxido, qtdCilindroGasHelio);
        this.qtdCilindroGasHelio = qtdCilindroGasHelio;
        this.qtdCilindroMonoxido = qtdCilindroMonoxido;
        this.qtdCilindroDioxido = qtdCilindroDioxido;
        this.qtdCilindroCheio = qtdCilindroCheio;
        this.pedido = pedido;
    }

    private void validaEstoqueDeCilindros(int qtdCilindroCheio, int qtdCilindroDioxido, int qtdCilindroMonoxido, int qtdCilindroGasHelio)
    throws Exception{
        validaSePossuiDezCilindrosCheios(qtdCilindroCheio);
        validaSeExisteCilindroDeDioxidoDisponivel(qtdCilindroDioxido);
        validaSeExisteCilindroDeMonoxidoDisponivel(qtdCilindroMonoxido);
        validaSeExisteCilindroDeGasHelioDisponivel(qtdCilindroGasHelio);
    }

    private void validaSePossuiDezCilindrosCheios(int qtdCilindroCheio) throws Exception {
        if(qtdCilindroCheio < 10){
            throw new Exception("O estoque de cilindros cheios não pode ser menor que 10.");
        }
    }

    private void validaSeExisteCilindroDeGasHelioDisponivel(int qtdCilindroGasHelio) throws Exception {
        if(qtdCilindroGasHelio == 0){
            throw new Exception("Não possuímos cilindros de Gás Hélio disponível. Iremos solicitar para o fornecedor.");
        }
    }

    private void validaSeExisteCilindroDeMonoxidoDisponivel(int qtdCilindroMonoxido) throws Exception {
        if(qtdCilindroMonoxido == 0){
            throw new Exception("Não possuímos cilindros de Monóxido de Carbono disponível. Iremos solicitar para o fornecedor.");
        }
    }

    private void validaSeExisteCilindroDeDioxidoDisponivel(int qtdCilindroDioxido) throws Exception {
        if(qtdCilindroDioxido == 0){
            throw new Exception("Não possuímos cilindros de Dióxido de Carbono disponível. Iremos solicitar para o fornecedor.");
        }
    }
}