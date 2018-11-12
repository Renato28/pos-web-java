package br.com.devmedia.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmedia.domain.Produto;
import br.com.devmedia.repository.ProdutoRepository;
import br.com.devmedia.exception.ProdutoNotFoundException;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class ProdutoControllerApi {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Produto getProdutoById(@PathVariable(value = "id") Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNotFoundException("Produto", "id", id));
	}

	@PostMapping("/produtos")
	public Produto createProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/produtos/{id}")
	public Produto updateProduto(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto produtoDetails) {

		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNotFoundException("Produto", "id", id));

		produto.setNome(produtoDetails.getNome());
		produto.setDescricao(produtoDetails.getDescricao());
		

		Produto updatedProduto = produtoRepository.save(produto);
		return updatedProduto;
	}

	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Produto> deleteProduto(@PathVariable(value = "id") Long id) {

		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNotFoundException("Produto", "id", id));

		produtoRepository.delete(produto);
		return ResponseEntity.ok().build();
	}
}
