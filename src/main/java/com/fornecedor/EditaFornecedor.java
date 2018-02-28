package com.fornecedor;

import java.util.ArrayList;
import java.util.List;

public class EditaFornecedor {
    private List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();

    public EditaFornecedor(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    public String editaNomeFornecedor(String cnpj, String nome) {
        for(Fornecedor fornecedor : fornecedorList){
            if (fornecedor.getCnpj().equals(cnpj)) {
                fornecedor.setNome(nome);
                return "Fornecedor alterado com sucesso.";
            }
        }
        return null;
    }
}
