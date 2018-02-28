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

    public String editaTelefoneFornecedor(String cnpj, String telefone) {
        for(Fornecedor fornecedor : fornecedorList){
            if (fornecedor.getCnpj().equals(cnpj)) {
                fornecedor.setTelefone(telefone);
                return "Telefone alterado com sucesso.";
            }
        }
        return null;
    }

    public String editaEmailFornecedor(String cnpj, String email) {
        for(Fornecedor fornecedor : fornecedorList){
            if (fornecedor.getCnpj().equals(cnpj)) {
                fornecedor.setEmail(email);
                return "E-mail alterado com sucesso.";
            }
        }
        return null;
    }
}