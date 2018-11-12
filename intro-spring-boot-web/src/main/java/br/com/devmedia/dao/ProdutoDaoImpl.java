package br.com.devmedia.dao;

import br.com.devmedia.domain.Playlist;
import br.com.devmedia.domain.Produto;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Produto produto) {
		em.persist(produto);
	}

	@Override
	public List<Produto> recuperar() {
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	@Override
	public Produto recuperarPorID(long id) {
		// TODO Auto-generated method stub
		return em.find(Produto.class, id);
	}

	@Override
	public void atualizar(Produto produto) {
		em.merge(produto);
	}

	@Override
	public void excluir(long id) {
		em.remove(em.getReference(Produto.class, id));

	}
}
