package br.com.sinergia.Sinergia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Victor
 * @version 1.0
 */
@Entity
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostagem;

	@NotBlank
	@Size(min = 5, max = 50)
	private String titulo;

	@NotBlank
	@Size(min = 1, max = 300)
	private String conteudo;

	private Long linkMidia;

	@DateTimeFormat
	private Date data;

	/**
	 * @author Amanda
	 * @since 1.0
	 */
	@ManyToOne
	@JoinColumn(name = "fk_tema")
	@JsonIgnoreProperties({ "postagens" })
	private Tema temaRelacionado;

	/**
	 * @author Amanda
	 * @since 1.0
	 */
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties({ "postagens" })
	private Usuario usuarioRelacionado;

	public Long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;
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

	public Long getLinkMidia() {
		return linkMidia;
	}

	public void setLinkMidia(Long linkMidia) {
		this.linkMidia = linkMidia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTemaRelacionado() {
		return temaRelacionado;
	}

	public void setTemaRelacionado(Tema temaRelacionado) {
		this.temaRelacionado = temaRelacionado;
	}

	public Usuario getUsuarioRelacionado() {
		return usuarioRelacionado;
	}

	public void setUsuarioRelacionado(Usuario usuarioRelacionado) {
		this.usuarioRelacionado = usuarioRelacionado;

	}

}