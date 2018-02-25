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

    @Test
    public void editaTelefoneCliente() throws Exception {
        Cliente cliente = new Cliente(1, "123.456.789-00", "Erica", "98999-9999", "erica@email.com", "Rua ABC, 123", null);
        List<Cliente> clienteList = new ArrayList<Cliente>();
        clienteList.add(cliente);

        EditaCliente editaCliente = new EditaCliente(clienteList);

        Cliente clienteEditado = editaCliente.editaTelefoneCliente("123.456.789-00", "98899-0011");

        assertThat(clienteEditado.getTelefone(), is("98899-0011"));
    }

   @Test
   public void editaEmailCliente() throws Exception {
       Cliente cliente = new Cliente(1, "123.456.789-00", "Erica", "98999-9999", "erica@email.com", "Rua ABC, 123", null);
       List<Cliente> clienteList = new ArrayList<Cliente>();
       clienteList.add(cliente);

       EditaCliente editaCliente = new EditaCliente(clienteList);

       Cliente clienteEditado = editaCliente.editaEmailCliente("123.456.789-00", "ericaviana@email.com");

       assertThat(clienteEditado.getTelefone(), is("ericaviana@email.com"));
   }
}