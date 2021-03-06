package com.fornecedor;

import com.cliente.Cliente;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RemoveFornecedorTest {

    @Test
    public void deveRemoverFornecedorERetornarMensagemDeSucesso() throws Exception {
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        Date data = new Date();
        fornecedorList.add(new Fornecedor(1, "12.345.678/0000-01", "Forn1", "98888-9999", "forn1@email.com", data));
        fornecedorList.add(new Fornecedor(2, "12.345.678/0000-12", "Forn2", "98899-9999", "forn2@email.com", data));
        RemoveFornecedor removeFornecedor = new RemoveFornecedor(fornecedorList);

        String mensagem = removeFornecedor.removeFornecedorPorCnpj("12.345.678/0000-01");

        assertThat(mensagem, is("Fornecedor excluido com sucesso."));
    }

    @Test
    public void deveVerificarSeRemoveuFornecedor() throws Exception {
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        Date data = new Date();
        fornecedorList.add(new Fornecedor(1, "12.345.678/0000-01", "Forn1", "98888-9999", "forn1@email.com", data));
        fornecedorList.add(new Fornecedor(2, "12.345.678/0000-12", "Forn2", "98899-9999", "forn2@email.com", data));
        RemoveFornecedor removeFornecedor = new RemoveFornecedor(fornecedorList);

        removeFornecedor.removeFornecedorPorCnpj("12.345.678/0000-12");
        List<Fornecedor> fornecedoresNaoExcluidosList = removeFornecedor.getListaFornecedores();

        assertThat(fornecedoresNaoExcluidosList.size(), is(1));
    }
}