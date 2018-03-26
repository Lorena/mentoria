package com.xyz;

import com.pedido.Pedido;
import com.whiteGas.WhiteGas;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class XyzTest {

    @Test
    public void cadastraPedidoParaXyzComSucesso() throws Exception {
        int qtdCilindroGasHelio = 10;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        //Quando a XYZ é construida ela precisa ser construída passando o Pedido?
        // Acho que ela só precisa ser construído com o que realmente representa a empresa XYZ, qtdCilindroGasHelio, qtdCilindroMonoxido e qtdCilindroDioxido
        //Talvz o cadastrar pedido para a XYZ seja um método a parte ao invés de usar o construtor
        //o que acha?
        //No construtor só tem que estar as informações que fazem sentido para o objeto todo
        //Ficaria algo assim:
        // Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
        // xyz.cadastrarPedido(pedido);

        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);

        assertThat(xyz, is(not(nullValue())));
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverDezCilindrosCheios() throws Exception {
        int qtdCilindroGasHelio = 1;
        int qtdCilindroMonoxido = 1;
        int qtdCilindroDioxido = 1;
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido("Gás Hélio", 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        Xyz xyz = new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
    }

    @Test(expected = Exception.class)
    public void deveRetornarErroSeNaoHouverCilindroParaGasPedido() throws Exception {
        int qtdCilindroGasHelio = 0;
        int qtdCilindroMonoxido = 20;
        int qtdCilindroDioxido = 10;
        int qtdCilindroCheio = qtdCilindroDioxido + qtdCilindroGasHelio + qtdCilindroMonoxido;
        String gas = "Gás Hélio";
        Date dataPedido = new Date();
        Date dataEntrega = new SimpleDateFormat("yyyyMMdd").parse("20180330");

        Pedido pedido = new Pedido(gas, 5.0, "Rua ABC", "Rua ABC", dataPedido, dataEntrega);
        new Xyz(qtdCilindroGasHelio, qtdCilindroMonoxido, qtdCilindroDioxido);
    }
}