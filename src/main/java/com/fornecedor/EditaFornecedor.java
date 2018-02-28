package com.fornecedor;

import java.util.ArrayList;
import java.util.List;

public class EditaFornecedor {
    private List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();

    public String editaNomeFornecedor(String cnpj, String nome) {
        for(Fornecedor fornecedor : fornecedorList){
            if (fornecedor.getCnpj().equals(cnpj)) {

            }
        }
        return null;
    }
}
