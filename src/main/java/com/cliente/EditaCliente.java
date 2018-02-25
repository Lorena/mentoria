package com.cliente;

import java.util.List;

public class EditaCliente {

    private List<Cliente> clienteList;

    public EditaCliente(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Cliente editaNomeCliente(String cpf, String nome) {
        for(Cliente cliente : clienteList){
            if(cliente.getCpf().equals(cpf)) {
                cliente.setNome(nome);
                return cliente;
            }
        }
        return null;
    }

    public Cliente editaTelefoneCliente(String cpf, String telefone) {
        for(Cliente cliente : clienteList){
            if(cliente.getCpf().equals(cpf)){
                cliente.setTelefone(telefone);
                return cliente;
            }
        }
        return null;
    }
}
