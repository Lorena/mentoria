package com.cliente;

import org.junit.Test;
import com.cliente.Cliente;

public class ClienteTest {

    //pode criar os testes com qualquer ideia que vc tiver....

    @Test(expected = Exception.class)
    public void naoDeveCadastrarClienteQuandoNaoExistirCpf() throws Exception {
     new Cliente(1, null, "Erica", "98999-9999", "erica@email.com", "Rua ABC, 123", null);
    }


}