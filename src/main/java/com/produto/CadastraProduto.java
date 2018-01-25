package com.produto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.produto.model.Produto;

public class CadastraProduto {
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public String cadastrar(String codigo, String nome, double preco, int quantidadeEstoque, int estoqueMinima, Date dataCadastro) throws ParseException {

        if(codigo == null || validaDataCadastro(dataCadastro)) {
            return "Produto nao cadastrado";
        }
        listaProdutos.add(produto);
        return "Cadastrada com sucesso!!";
    }

    private boolean validaDataCadastro(Date dataCadastro) throws ParseException {
        String dateAtualString = dateFormat.format(new Date());
        Date dataAtual = dateFormat.parse(dateAtualString);
        return dataCadastro.after(dataAtual);
    }
}
