package com.springuninter.bo;

import java.util.List;
import com.springuninter.dao.CRUD;
import com.springuninter.dao.NotaEntradaItemDao;
import com.springuninter.model.NotaEntradaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaEntradaItemBO implements CRUD<NotaEntradaItem, Long>{

    @Autowired
    private NotaEntradaItemDao dao;

    @Override
    public NotaEntradaItem pesquisapeloId(Long id) {
        return dao.pesquisapeloId(id);
    }

    @Override
    public List<NotaEntradaItem> lista() {
        return dao.lista();
    }

    @Override
    public void insere(NotaEntradaItem notaEntradaItem) {
        dao.insere(notaEntradaItem);
    }

    @Override
    public void atualiza(NotaEntradaItem notaEntradaItem) {
        dao.atualiza(notaEntradaItem);
    }

    @Override
    public void remove(NotaEntradaItem notaEntradaItem) {
        dao.remove(notaEntradaItem);
    }

    public boolean itemJaAdicionado(NotaEntradaItem notaEntradaItem) {
        Long notaEntradaId = notaEntradaItem.getNotaEntrada().getId();
        List<NotaEntradaItem> itens = dao.listaItensNota(notaEntradaId);

        Long produtoId = notaEntradaItem.getProduto().getId();

        if (notaEntradaItem.getId() == null) {
            for (NotaEntradaItem item : itens) {
                if (item.getProduto().getId() == produtoId) {
                    return true;
                }
            }
        } else {
            Long notaEntradaItemId = notaEntradaItem.getId();
            for (NotaEntradaItem item : itens) {
                if (item.getProduto().getId() == produtoId && notaEntradaItemId != item.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

}

