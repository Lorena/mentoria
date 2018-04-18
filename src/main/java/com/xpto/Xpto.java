package com.xpto;

import com.cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Xpto {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> agendarPedidoDoClienteComUmaSemanaDeAntecedencia(Cliente cliente) {
        clientes.add(cliente);
        return clientes;
    }
}