package br.com.devmedia.service;

import br.com.devmedia.domain.Produto;

import java.util.List;

public interface ProdutoService {

    void salvar(Produto produto);
    List<Produto> recuperar();
    Produto recuperarPorId(long id);
    void atualizar(Produto produto);
    void excluir(long id);

}
