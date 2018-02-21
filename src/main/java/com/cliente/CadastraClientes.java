package com.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastraClientes {
    private List<Cliente> produtos = new ArrayList<Cliente>();
    private int codigo;

    public List<Cliente> cadastraCliente(int codigo, String cpf, String nome, String telefone, String email, String endereco, Date dataCadastro) throws Exception {
        produtos.add(new Cliente(codigo, cpf, nome, telefone, email, endereco, dataCadastro));
        return produtos;
    }

    public int getCodigo() {
        return codigo;
    }
}
