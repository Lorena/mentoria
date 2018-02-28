package com.fornecedor;

import java.util.List;

public class RemoveFornecedor {

    private List<Fornecedor> fornecedorList;

    public RemoveFornecedor(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    public String removeFornecedorPorCnpj(String cnpj) {
        for(Fornecedor fornecedor : fornecedorList){
            if(fornecedor.getCnpj().equals(cnpj)){
                fornecedorList.remove(fornecedor);
                return "Fornecedor excluido com sucesso.";
            }
        }
        return null;
    }
}
