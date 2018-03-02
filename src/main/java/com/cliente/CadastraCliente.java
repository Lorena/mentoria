package com.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastraCliente {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> cadastraClientes(String cpf, String nome, String telefone, String email, Date dataNascimento) throws Exception {
        clientes.add(new Cliente(cpf, nome, telefone, email, dataNascimento ));
       return clientes;
    }

    public List<Cliente> getClientesCadastrados() {
        return clientes;
    }
}