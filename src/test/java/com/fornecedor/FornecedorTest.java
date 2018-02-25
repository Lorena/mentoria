package com.fornecedor;

import org.junit.Test;

import static org.junit.Assert.*;

public class FornecedorTest {

    @Test(expected = Exception.class)
    public void naoDeveCadastrarFornecedorQuandoNaoExistirCnpj() throws Exception {
        new Fornecedor(1, null, "Forn1", "98888-9999", "forn1@email.com", null);
    }
}