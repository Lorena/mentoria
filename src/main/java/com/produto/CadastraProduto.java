package com.produto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastraProduto {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public String cadastrar(String codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinima, Date dataCadastro) throws ParseException {

        if(codigo == null || validaDataCadastro(dataCadastro)) {
            return "Produto nao cadastrado";
        }
        return "Cadastrada com sucesso!!";
    }

    private boolean validaDataCadastro(Date dataCadastro) throws ParseException {
        String dateAtualString = dateFormat.format(new Date());
        Date dataAtual = dateFormat.parse(dateAtualString);
        return dataCadastro.after(dataAtual);
    }
}
