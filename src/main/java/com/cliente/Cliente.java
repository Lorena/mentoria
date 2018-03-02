package com.cliente;

import java.util.Date;

public class Cliente {

    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Date dataNascimento;

    public Cliente(String cpf, String nome, String telefone, String email, Date dataNascimento)
            throws Exception{
        if (cpf == null || telefone == null && email == null){
            throw new Exception("Produto não cadastrado.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}