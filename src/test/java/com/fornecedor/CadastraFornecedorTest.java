package com.fornecedor;

import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CadastraFornecedorTest {
    private CadastraFornecedor cadastraFornecedor;

    @Before
    public void setUp() throws Exception {
        cadastraFornecedor = new CadastraFornecedor();
    }

    @Test
    public void deveCadastrarMultiplosFornecedores() throws Exception {
        Date dataCadastro = new SimpleDateFormat("yyyyMMdd").parse("20180227");

        List<Fornecedor> fornecedorList = cadastraFornecedor.cadastraFornecedor(1, "12.345.678/0000-01", "Forn1", "98888-9999", "forn1@email.com", dataCadastro);

        assertThat(fornecedorList.size(), is(1));

        fornecedorList = cadastraFornecedor.cadastraFornecedor(2, "12.345.678/0000-02", "Forn2", "98899-9999", "forn2@email.com", dataCadastro);

        assertThat(fornecedorList.size(), is(2));
    }
}