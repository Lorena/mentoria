package com.cliente;

import java.util.List;

public class RemoverCliente {
    private List<Cliente> listaDeCliente;

    public RemoverCliente(List<Cliente> listaDeCliente) {
        this.listaDeCliente = listaDeCliente;
    }

    public String removerClientePorCPF(String cpf) throws ClienteNaoEncontradoException {
       Cliente cliente = getClientePorCpf(cpf);
       listaDeCliente.remove(cliente);
        return "Cliente foi removido com sucesso!!";
    }

    private Cliente getClientePorCpf(String cpf) throws ClienteNaoEncontradoException {
        for (Cliente cliente : listaDeCliente){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        throw new ClienteNaoEncontradoException();
    }

    public List<Cliente> getListaDeCliente() {
        return listaDeCliente;
    }
}