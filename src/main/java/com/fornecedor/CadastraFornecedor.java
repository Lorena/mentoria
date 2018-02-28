package com.fornecedor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastraFornecedor {
    private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

    public List<Fornecedor> cadastraFornecedor(int codigo, String cnpj, String nome, String telefone, String email, Date dataCadastro)
    throws Exception {
        fornecedores.add(new Fornecedor(codigo, cnpj, nome, telefone, email, dataCadastro));
        return fornecedores;
    }

    public List<Fornecedor> getFornecedoresCadastrados() {
        return fornecedores;
    }
}