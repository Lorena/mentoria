package com.cliente;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RemoverClienteTest {

    @Test
    public void deveRemoverClientePorCPFmostrandoMensagemDeSucessso() throws Exception, ClienteNaoEncontradoException {

        List<Cliente> listaDeCliente = new ArrayList<Cliente>();
        Date data = new Date();
        listaDeCliente.add(new Cliente("000.000.000-00", "Lorena", "99999999", "lorena@tw.com.br", null, null));
        RemoverCliente removerCliente = new RemoverCliente(listaDeCliente);

       String mensagem = removerCliente.removerClientePorCPF("000.000.000-00");

       assertThat(mensagem, is("Cliente foi removido com sucesso!!"));
    }

    @Test
    public void deveRetornarListaDeClientesNaoDeletados() throws Exception {
        List<Cliente> listaDeCliente = new ArrayList<Cliente>();
        Date data = new Date();
        listaDeCliente.add(new Cliente("000.000.000-00", "Lorena", "99999999", "lorena@tw.com.br", null, null));
        RemoverCliente removerCliente = new RemoverCliente(listaDeCliente);

        List<Cliente> clienteLista = removerCliente.getListaDeCliente();

        assertThat(clienteLista.size(), is(1));
    }

    @Test
    public void deveVerificarSeExcluiuOCliente() throws Exception, ClienteNaoEncontradoException {
        List<Cliente> listaDeCliente = new ArrayList<Cliente>();
        Date data = new Date();
        listaDeCliente.add(new Cliente("000.000.000-00", "Lorena", "99999999", "lorena@tw.com.br", null, null));
        RemoverCliente removerCliente = new RemoverCliente(listaDeCliente);

        removerCliente.removerClientePorCPF("000.000.000-00");
        List<Cliente> listaDeClienteNaoExcluidos = removerCliente.getListaDeCliente();

        assertThat(listaDeClienteNaoExcluidos.size(), is(0));
    }
}