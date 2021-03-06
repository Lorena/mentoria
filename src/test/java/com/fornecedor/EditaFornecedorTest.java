package com.fornecedor;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EditaFornecedorTest {

    @Test
    public void deveEditarNomeDoFornecedorERetornarMensagemDeSucesso() throws Exception {
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        Date data = new Date();
        Fornecedor fornecedor = new Fornecedor(1, "12.345.678/0000-01", "Forn1", "98888-9999", "forn1@email.com", data);
        fornecedorList.add(fornecedor);

        EditaFornecedor editaFornecedor = new EditaFornecedor(fornecedorList);
        String mensagem = editaFornecedor.editaNomeFornecedor("12.345.678/0000-01", "Fornecedor Um");

        assertThat(mensagem, is("Fornecedor alterado com sucesso."));
    }

    @Test
    public void deveEditarTelefoneDoFornecedorERetornarMensagemDeSucesso() throws Exception {
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        Date data = new Date();
        Fornecedor fornecedor = new Fornecedor(1, "12.345.678/0000-01", "Forn1", "98888-9999", "forn1@email.com", data);
        fornecedorList.add(fornecedor);

        EditaFornecedor editaFornecedor = new EditaFornecedor(fornecedorList);
        String mensagem = editaFornecedor.editaTelefoneFornecedor("12.345.678/0000-01", "3030-4040");

        assertThat(mensagem, is("Telefone alterado com sucesso."));
    }

    @Test
    public void deveEditarEmailDoFornecedorERetornarMensagemDeSucesso() throws Exception {
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        Date data = new Date();
        Fornecedor fornecedor = new Fornecedor(1, "12.345.678/0000-01", "Forn1", "98888-9999", "forn1@email.com", data);
        fornecedorList.add(fornecedor);

        EditaFornecedor editaFornecedor = new EditaFornecedor(fornecedorList);
        String mensagem = editaFornecedor.editaEmailFornecedor("12.345.678/0000-01", "fornecedor1@email.com");

        assertThat(mensagem, is("E-mail alterado com sucesso."));
    }
}