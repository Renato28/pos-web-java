package br.com.devmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmedia.domain.Produto;


/**
 * This use JpaRepository that extends the PagingAndSortingRepository that extends CRUDRepository.
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
