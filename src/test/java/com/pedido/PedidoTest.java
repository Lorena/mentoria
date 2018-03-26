package com.pedido;

import org.joda.time.Days;
import org.joda.time.ReadableInstant;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180329");
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180310");

        Pedido pedido = new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);

        assertThat(pedido, is(not(nullValue())));
    }

    @Test
    public void verificaSeEnderecoDeEntregaERecuperacaoEIgualParaDioxido() throws Exception {
        String gas = "Dióxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180310");
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180329");

        Pedido pedido = new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);

        assertThat(pedido.getEnderecoRecuperacao(), is(pedido.getEnderecoEntrega()));
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarSeEnderecoDeEntregaForDiferenteDeEnderecoRecuperacaoParaDioxido() throws Exception {
        String gas = "Dióxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua EFG";
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180329");
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180310");

        new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);
    }

    @Test
    public void verificaSeEnderecoDeEntregaERecuperacaoEIgualParaMonoxido() throws Exception {
        String gas = "Monóxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180329");
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180310");

        Pedido pedido = new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);

        assertThat(pedido.getEnderecoRecuperacao(), is(pedido.getEnderecoEntrega()));
    }

    @Test(expected = Exception.class)
    public void naoDeveCadastrarSeEnderecoDeEntregaForDiferenteDeEnderecoRecuperacaoParaMonoxido() throws Exception {
        String gas = "Monóxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua EFG";
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180329");
        Date dataPedido = new Date();

        new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);
    }

    @Test (expected = Exception.class)
    public void naoDeveCadastrarPedidoSeDataEntregaTerMenosDeSeteDiasAntecedencia() throws Exception {
        String gas = "Monóxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180309");
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180329");

        new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);
    }

    @Test (expected = Exception.class)
    public void naoDeveCadastrarPedidoSeDataEntregaForIgualADataPedido() throws Exception {
            String gas = "Monóxido de Carbono";
            double quantidadeMmCubicos = 5.0 ;
            String enderecoEntrega = "Rua ABC";
            String enderecoRecuperacao = "Rua ABC";
            Date dataEntrega = new Date();
            Date dataPedido = new Date();

            new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);
    }

    @Test (expected = Exception.class)
    public void naoDeveCadastrarPedidoSeDataPedidoForAposDataEntrega() throws Exception {
        String gas = "Monóxido de Carbono";
        double quantidadeMmCubicos = 5.0 ;
        String enderecoEntrega = "Rua ABC";
        String enderecoRecuperacao = "Rua ABC";
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180309");
        Date dataPedido = new SimpleDateFormat("yyyyMMdd").parse("20180315");

        new Pedido(gas, quantidadeMmCubicos, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);
    }
}