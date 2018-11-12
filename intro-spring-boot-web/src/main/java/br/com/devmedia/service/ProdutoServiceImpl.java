package br.com.devmedia.service;


import br.com.devmedia.dao.ProdutoDao;
import br.com.devmedia.domain.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public void salvar(Produto produto) {
        produtoDao.salvar(produto);
    }

    @Override
    public void atualizar(Produto produto) {
        produtoDao.atualizar(produto);
    }

    @Override
    public void excluir(long id) {
        produtoDao.excluir(id);
    }

	@Override
	public Produto recuperarPorId(long id) {
		// TODO Auto-generated method stub
		return produtoDao.recuperarPorID(id);
	}

	@Override
	public List<Produto> recuperar() {
		// TODO Auto-generated method stub
		return produtoDao.recuperar();
	}

}
