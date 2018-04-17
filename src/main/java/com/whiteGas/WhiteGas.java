package com.whiteGas;

import com.pedido.Pedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WhiteGas {

    private String gas;
    private int qtdCilindros;
    private Date dataPedido;
    private Date dataEnvioPedido;
    private List<Pedido> pedidoList = new ArrayList<>();

    public WhiteGas(String gas, int qtdCilindros) throws Exception{
        this.gas = gas;
        this.qtdCilindros = qtdCilindros;
    }

    public List<Pedido> cadastraPedido(Pedido pedido, Date dataPedido, Date dataEnvioPedido) throws Exception {
        validaDataPedidoAntesDeQuintaFeira(dataPedido);
        validaDataEnvioPedidoAntesDeSextaFeira(dataEnvioPedido);
        pedidoList.add(pedido);
        return pedidoList;
    }

    private void validaDataPedidoAntesDeQuintaFeira(Date dataPedido) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataValidar = sdf.parse(String.valueOf(dataPedido));
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataValidar);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);

        if(diaDaSemana >= 5){
            throw new Exception("Os pedidos são fechados às quintas-feiras.");
        }
    }

    private void validaDataEnvioPedidoAntesDeSextaFeira(Date dataEnvioPedido) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataValidar = sdf.parse(String.valueOf(dataEnvioPedido));
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataValidar);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);

        if(diaDaSemana >= 6){
            throw new Exception("Os pedidos são enviados às sextas-feiras.");
        }
    }
}