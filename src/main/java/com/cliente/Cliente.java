package com.cliente;

import java.util.Date;

public class Cliente {
    private int codigo;

    public Cliente(int codigo, String cpf, String nome, String telefone, String email, String endereco, Date dataCadastro)
            throws Exception{
    if (cpf == null || cpf == " "){
        throw new Exception("Produto não cadastrado.");
    }
    }

    public int getCodigo() {
        return codigo;
    }

    //Não construir a classe cliente gerando todos os atributos
    //Antes de colocar qualquer coisa na classe cliente, primeiro fazer testes para ela.
}
