package com.springuninter.bo;

import com.springuninter.dao.CRUD;
import com.springuninter.dao.FornecedorDao;
import com.springuninter.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class FornecedorBo implements CRUD<Fornecedor, Long> {
@Autowired
private FornecedorDao fornecedorDao;

@Override
public Fornecedor pesquisapeloId(Long id){

        return fornecedorDao.pesquisapeloId(id);
        }

@Override
public List<Fornecedor> lista(){

        return fornecedorDao.lista();
        }

@Override
public void insere(Fornecedor fornecedor){

        fornecedorDao.insere(fornecedor);

        }
@Override
public void atualiza(Fornecedor fornecedor){

        fornecedorDao.pesquisapeloId(fornecedor.getId());
        fornecedorDao.atualiza(fornecedor);

        }
@Override
public void remove(Fornecedor fornecedor){

        fornecedorDao.remove(fornecedor);
        }

public void inativa(Fornecedor fornecedor){

    fornecedor.setAtivo(false);
        fornecedorDao.atualiza(fornecedor);

        }


public void ativa(Fornecedor cliente){

        cliente.setAtivo(true);
        fornecedorDao.atualiza(cliente);

        }

}


