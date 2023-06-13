package com.springuninter.bo;

import java.util.List;
import com.springuninter.dao.CRUD;
import com.springuninter.dao.NotaEntradaDao;
import com.springuninter.model.NotaEntrada;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class NotaEntradaBO  implements CRUD<NotaEntrada, Long> {

    @Autowired
    private NotaEntradaDao notaEntradaDao;

    @Override
    public NotaEntrada pesquisapeloId(Long id) {

        return notaEntradaDao.pesquisapeloId(id);

    }

    @Override
    public List<NotaEntrada> lista() {
        return notaEntradaDao.lista();
    }

    @Override
    public void insere(NotaEntrada notaEntrada) {
        notaEntradaDao.insere(notaEntrada);
    }

    @Override
    public void atualiza(NotaEntrada notaEntrada) {
        notaEntradaDao.atualiza(notaEntrada);
    }

    @Override
    public void remove(NotaEntrada notaEntrada) {
        notaEntradaDao.remove(notaEntrada);
    }
}


