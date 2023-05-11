package com.springuninter.bo;

import java.util.List;

import com.springuninter.dao.CRUD;
import com.springuninter.dao.ProdutoDao;
import com.springuninter.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBO implements CRUD<Produto, Long> {

    @Autowired
    private ProdutoDao dao;

    @Override
    public Produto pesquisapeloId(Long id) {
        return dao.pesquisapeloId(id);
    }

    @Override
    public List<Produto> lista() {
        return dao.lista();
    }

    @Override
    public void insere(Produto produto) {
        dao.insere(produto);

    }

    @Override
    public void atualiza(Produto produto) {
        dao.atualiza(produto);
    }

    @Override
    public void remove(Produto produto) {
        dao.remove(produto);
    }

    public void ativa(Produto produto) {
        produto.setAtivo(true);
        dao.atualiza(produto);
    }

    public void inativa(Produto produto) {
        produto.setAtivo(false);
        dao.atualiza(produto);
    }

}

