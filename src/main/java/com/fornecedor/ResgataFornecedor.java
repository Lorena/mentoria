package com.fornecedor;

import java.util.List;

public class ResgataFornecedor {
    private List<Fornecedor> fornecedorList;

    public Fornecedor resgatarFornecedorPorCnpj(String cnpj) {
        for(Fornecedor fornecedor : fornecedorList){
            if(fornecedor.getCnpj().equals(cnpj)){
                return fornecedor;
            }
        }
        return null;
    }

    public ResgataFornecedor(List<Fornecedor> fornecedoresCadastrados) {
        this.fornecedorList = fornecedoresCadastrados;
    }
}
