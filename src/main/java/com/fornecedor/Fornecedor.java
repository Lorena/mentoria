package com.fornecedor;

import java.util.Date;

public class Fornecedor {

    private int codigo;
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private Date dataCadastro;

    public Fornecedor(int codigo, String cnpj, String nome, String telefone, String email, Date dataCadastro) throws Exception{
        if(cnpj == null || cnpj == " "){
            throw new Exception("Fornecedor não cadastrado");
        }
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public String getCnpj() {
        return cnpj;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = this.nome;
    }
}
