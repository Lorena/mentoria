package com.cliente;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EditaClienteTest {

    @Test
    public void editaNomeCliente() throws Exception {
        Cliente cliente = new Cliente(1, "123.456.789-00", "Erica", "98999-9999", "erica@email.com", "Rua ABC, 123", null);
        List<Cliente> clienteList = new ArrayList<Cliente>();
        clienteList.add(cliente);

        EditaCliente editaCliente = new EditaCliente(clienteList);

        Cliente clienteEditado = editaCliente.editaNomeCliente("123.456.789-00", "Erica Viana");

        assertThat(clienteEditado.getNome(), is("Erica Viana"));
    }
}