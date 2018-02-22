package com.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastraCliente {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> cadastraClientes(int codigo, String cpf, String nome, String telefone, String email,
                                          String endereco, Date dataCadastro) throws Exception {
        clientes.add(new Cliente(codigo, cpf, nome, telefone, email, endereco, dataCadastro));
       return clientes;
    }

    public List<Cliente> getClientesCadastrados() {
        return clientes;
    }
}