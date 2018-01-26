package com.produto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.produto.model.Produto;

public class CadastraProduto {

    public Produto cadastrar(int codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinima, Date dataCadastro) throws Exception {

        if(codigo == 0 || validaDataCadastro(dataCadastro)) {
            throw new Exception("Produto não cadastrado");
        }
        return new Produto(codigo, nome, preco, quantidadeEstoque, estoqueMinima, dataCadastro);
    }

    private boolean validaDataCadastro(Date dataCadastro) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateAtualString = dateFormat.format(new Date());
        Date dataAtual = dateFormat.parse(dateAtualString);
        return dataCadastro.after(dataAtual);
    }
}