package com.cliente;

import java.util.Date;
import java.util.List;

public class Cliente {
    private int codigo;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Date dataCadastro;

    public Cliente(int codigo, String cpf, String nome, String telefone, String email, String endereco, Date dataCadastro)
            throws Exception{
        if (cpf == null || telefone == null && email == null){
            throw new Exception("Produto não cadastrado.");
        }
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    //Não construir a classe cliente gerando todos os atributos
    //Antes de colocar qualquer coisa na classe cliente, primeiro fazer testes para ela.
}
