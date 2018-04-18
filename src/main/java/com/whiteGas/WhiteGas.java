package com.whiteGas;

import com.pedido.Pedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WhiteGas {

    private Date dataEnvioPedido = new SimpleDateFormat("yyyyMMdd").parse("20180427");
    private List<Pedido> pedidoList = new ArrayList<>();

    public WhiteGas() throws ParseException {

    }

    public List<Pedido> cadastraPedidos(Pedido pedido, Date dataPedido) throws Exception {
        validaDataPedidoAntesDeQuintaFeira(dataPedido);
        pedidoList.add(pedido);
        return pedidoList;
    }

    public List<Pedido> entregaPedidos() throws Exception {
        validaDataEnvioPedidoAntesDeSextaFeira();
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

    private void validaDataEnvioPedidoAntesDeSextaFeira() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataValidar = sdf.parse(String.valueOf(this.dataEnvioPedido));
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataValidar);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);

        if(diaDaSemana >= 6){
            throw new Exception("Os pedidos são enviados às sextas-feiras.");
        }
    }
}