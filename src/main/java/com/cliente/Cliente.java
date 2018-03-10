package com.cliente;

import com.pedido.Pedido;
import java.util.Date;

public class Cliente {

    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private Pedido pedido;

    public Cliente(String cpf, String nome, String telefone, String email, Date dataNascimento, Pedido pedido)
            throws Exception{
        if (cpf == null || telefone == null && email == null){
            throw new Exception("Produto não cadastrado.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.pedido = pedido;
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