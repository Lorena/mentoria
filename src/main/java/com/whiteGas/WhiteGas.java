package com.whiteGas;

import com.pedido.Pedido;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class WhiteGas {
    private Pedido pedido;
    private int qtdNovosCilindros;
    private Date dataPedido;


    public WhiteGas(Pedido pedido, int qtdNovosCilindros, Date dataPedido) throws Exception {
        validaDataPedidoAntesDeQuintaFeira(dataPedido);
        this.pedido = pedido;
        this.qtdNovosCilindros = qtdNovosCilindros;
        this.dataPedido = dataPedido;
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

}
