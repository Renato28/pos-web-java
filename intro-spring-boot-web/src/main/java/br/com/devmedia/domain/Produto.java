package br.com.devmedia.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(min = 2, max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

	@NotBlank
	@Column(nullable = false)
	private String descricao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
