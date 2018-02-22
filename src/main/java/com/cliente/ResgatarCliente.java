package com.cliente;

import java.util.ArrayList;
import java.util.List;

public class ResgatarCliente {
    private List<Cliente> clientes;

    public List<Cliente> resgatarClientePeloCpf(String cpf) {
        List<Cliente> clienteComCpfInformado = new ArrayList<Cliente>();
        for(Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpf)){
               clienteComCpfInformado.add(cliente);
            }
        }
        return clienteComCpfInformado;
    }
}