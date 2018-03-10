package com.pedido;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableInstant;

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
        validaPedido(gas, enderecoEntrega, enderecoRecuperacao, dataPedido, dataEntrega);
        this.gas = gas;
        this.quantidadeMmCubicos = quantidadeMmCubicos;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoRecuperacao = enderecoRecuperacao;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
    }

    private void validaPedido(String gas, String enderecoEntrega, String enderecoRecuperacao, Date dataPedido, Date dataEntrega) throws Exception {
        verificaEnderecoValidoParaMonoxidoOuDioxido(gas, enderecoEntrega, enderecoRecuperacao);
        verificaSeDataEntregaEValida(dataPedido, dataEntrega);
    }

    private void verificaEnderecoValidoParaMonoxidoOuDioxido(String gas, String enderecoEntrega, String enderecoRecuperacao) throws Exception {
        verificaEnderecoValidoParaMonoxido(gas, enderecoEntrega, enderecoRecuperacao);
       verificaEnderecoValidoParaDioxido(gas, enderecoEntrega, enderecoRecuperacao);
    }

    private void verificaEnderecoValidoParaMonoxido(String gas, String enderecoEntrega, String enderecoRecuperacao) throws Exception {
        if(gas.equals("Monóxido de Carbono") && !enderecoEntrega.equals(enderecoRecuperacao)){
            throw new Exception("Endereço de entrega não pode ser diferente do endereço de recuperação.");
        }
    }

    private void verificaEnderecoValidoParaDioxido(String gas, String enderecoEntrega, String enderecoRecuperacao) throws Exception {
        if(gas.equals("Dióxido de Carbono") && !enderecoEntrega.equals(enderecoRecuperacao)){
            throw new Exception("Endereço de entrega não pode ser diferente do endereço de recuperação.");
        }
    }

    private void verificaSeDataEntregaEValida(Date dataPedido, Date dataEntrega) throws Exception {
        verificaSeDataEntregaEIgualADataPedido(dataPedido, dataEntrega);
        verificaSeDataPedidoEAposDataEntrega(dataPedido, dataEntrega);
        verificaSeDataPedidoTemSeteDiasAntecedencia(dataPedido, dataEntrega);
    }

    private void verificaSeDataEntregaEIgualADataPedido(Date dataPedido, Date dataEntrega) throws Exception {
        if(dataPedido.equals(dataEntrega)){
            throw new Exception("Data de entrega não pode ser igual a data do pedido.");
        }
    }

    private void verificaSeDataPedidoEAposDataEntrega(Date dataPedido, Date dataEntrega) throws Exception {
        if(dataPedido.after(dataEntrega)){
            throw new Exception("A data do pedido não pode ser após a data de entrega");
        }
    }

    private void verificaSeDataPedidoTemSeteDiasAntecedencia(Date dataPedido, Date dataEntrega) throws Exception {
        LocalDate data1 = new LocalDate(dataPedido);
        LocalDate data2 = new LocalDate(dataEntrega);
        int dias = Days.daysBetween(data1, data2).getDays();

        if(dias < 7){
            throw new Exception("O pedido deve ter no mínimo 7 dias de antecedência.");
        }
    }

    public String getEnderecoRecuperacao() {
        return enderecoRecuperacao;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
}