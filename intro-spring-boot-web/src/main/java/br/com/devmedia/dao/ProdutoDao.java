package br.com.devmedia.dao;

import br.com.devmedia.domain.Produto;

import java.util.List;

public interface ProdutoDao {

    void salvar(Produto produto);
    List<Produto> recuperar();
    Produto recuperarPorID(long id);
    void atualizar(Produto produto);
    void excluir(long id);

}

