package com.pedido;

import java.util.Date;

public class Pedido {

    private String gas;
    private double quantidadeMmCubicos;
    private String enderecoEntrega;
    private String enderecoRecuperacao;
    private Date dataPedido;
    private Date dataEntrega;

    public Pedido(String gas, double quantidadeMmCubicos, String enderecoEntrega, String enderecoRecuperacao, Date dataPedido, Date dataEntrega)
    throws Exception{
        verificaEnderecoValidoParaMonoxidoOuDioxido(gas, enderecoEntrega, enderecoRecuperacao);
        verificaSeDataEntregaEValida(dataPedido, dataEntrega);
        this.gas = gas;
        this.quantidadeMmCubicos = quantidadeMmCubicos;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoRecuperacao = enderecoRecuperacao;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataPedido;
    }

    private void verificaEnderecoValidoParaMonoxidoOuDioxido(String gas, String enderecoEntrega, String enderecoRecuperacao) throws Exception {
        if(gas.equals("Dióxido de Carbono") || gas.equals("Monóxido de Carbono") && !enderecoEntrega.equals(enderecoRecuperacao)){
            throw new Exception("Pedido não cadastrado.");
        }
    }

    private void verificaSeDataEntregaEValida(Date dataPedido, Date dataEntrega) throws Exception {
        if(dataPedido.equals(dataEntrega) || dataPedido.after(dataEntrega)){
            throw new Exception("Pedido não cadastrado.");
        }
    }

    public String getEnderecoRecuperacao() {
        return enderecoRecuperacao;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }
}