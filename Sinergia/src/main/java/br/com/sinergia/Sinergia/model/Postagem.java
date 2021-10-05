package br.com.sinergia.Sinergia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Victor
 * @version 1.0
 */
@Entity
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Postagem;

	@NotBlank
	@Size(min = 5, max = 50)
	private String titulo;

	@NotBlank
	@Size(min = 1, max = 300)
	private String conteudo;

	@NotBlank
	private Long link_midia;

	@DateTimeFormat
	private Date data;

	public Long getId_Postagem() {
		return id_Postagem;
	}

	public void setId_Postagem(Long id_Postagem) {
		this.id_Postagem = id_Postagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Long getLink_midia() {
		return link_midia;
	}

	public void setLink_midia(Long link_midia) {
		this.link_midia = link_midia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
