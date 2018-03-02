package com.pedido;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class PedidoTest {

    @Test
    public void deveCadastrarPedidoComSucesso() throws Exception {
        String gas = "Gás Hélio";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";

        Pedido pedido = new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataEntrega);

        assertThat(pedido, is(not(nullValue())));
    }

    @Test
    public void verificaSeEnderecoDeEntregaERecuperacaoEIgualParaDioxido() throws Exception {
        String gas = "Dióxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";
        Date dataPedido = new Date();

        Pedido pedido = new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido);

        assertThat(pedido.getEnderecoRecuperacao(), is(pedido.getEnderecoEntrega()));
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarSeEnderecoDeEntregaForDiferenteDeEnderecoRecuperacaoParaDioxido() throws Exception {
        String gas = "Dióxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua EFG";
        Date dataPedido = new Date();

       new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido);
    }

    @Test
    public void verificaSeEnderecoDeEntregaERecuperacaoEIgualParaMonoxido() throws Exception {
        String gas = "Monóxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";
        Date dataPedido = new Date();

        Pedido pedido = new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido);

        assertThat(pedido.getEnderecoRecuperacao(), is(pedido.getEnderecoEntrega()));
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarSeEnderecoDeEntregaForDiferenteDeEnderecoRecuperacaoParaMonoxido() throws Exception {
        String gas = "Monóxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua EFG";
        Date dataPedido = new Date();

        new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido);
    }
}