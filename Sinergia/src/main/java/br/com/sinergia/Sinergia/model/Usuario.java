package br.com.sinergia.Sinergia.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author João
 * @since 1.0
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@NotBlank
	private String nomeCompleto;

	/**
	 * @author Leonardo
	 * @version 1.1
	 */
	@ApiModelProperty(example = "email@email.com.br")
	@NotNull(message = "O atributo email é Obrigatório!")
	@Email(message = "O atributo email deve ser válido!")
	private String email;

	@NotBlank
	@Size(min = 8, max = 100)
	private String senha;

	/**
	 * @author Amanda
	 * @since 1.0
	 */
	@OneToMany(mappedBy = "usuarioRelacionado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "usuarioRelacionado" })
	private List<Postagem> postagens = new ArrayList<>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

}
