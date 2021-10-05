package br.com.sinergia.Sinergia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	/**
	 * Classe do Usuario.
	 * 
	 * @author João
	 * @since 1.0
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@NotBlank
	private String nome_completo;

	@Email
	private String email;

	@NotBlank
	@Size(min = 5, max = 10)
	private String senha;

	public Long getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.id_usuario = idUsuario;
	}

	public String getNome() {
		return nome_completo;
	}

	public void setNome(String nome) {
		this.nome_completo = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
