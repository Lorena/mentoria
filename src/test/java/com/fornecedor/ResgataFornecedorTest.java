package com.fornecedor;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ResgataFornecedorTest {
    private ResgataFornecedor resgataFornecedor;
    private CadastraFornecedor cadastraFornecedor = new CadastraFornecedor();

    @Test
    public void deveRetornarFornecedorPorCnpjInformado() throws Exception{
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180227");
        cadastraFornecedor.cadastraFornecedor(1, "12.345.678/0000-01", "Forn1", "98999-9999", "forn1@email.com", dataCadastro);
        cadastraFornecedor.cadastraFornecedor(2, "12.345.678/0000-12", "Forn2", "98999-9988", "forn2@email.com", dataCadastro);

        resgataFornecedor = new ResgataFornecedor(cadastraFornecedor.getFornecedoresCadastrados());

        Fornecedor fornecedorPorCnpj = resgataFornecedor.resgatarFornecedorPorCnpj("12.345.678/0000-01");

        assertThat(fornecedorPorCnpj.getCnpj(), is("12.345.678/0000-01"));
        assertThat(fornecedorPorCnpj.getCodigo(), is(1));
    }
}