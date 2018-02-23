package com.cliente;

import java.util.List;

public class ResgatarCliente {
    private List<Cliente> clientes;

    public ResgatarCliente(List<Cliente> clientesCadastrados) {
        clientes = clientesCadastrados;
    }

    public Cliente resgatarClientePeloCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf))
                return cliente;
        }
        return null;
    }
}