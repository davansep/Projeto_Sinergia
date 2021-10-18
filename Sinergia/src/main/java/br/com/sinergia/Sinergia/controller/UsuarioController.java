package br.com.sinergia.Sinergia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.sinergia.Sinergia.model.Usuario;
import br.com.sinergia.Sinergia.model.dtos.CredenciaisDTO;
import br.com.sinergia.Sinergia.model.dtos.UsuarioLoginDTO;
import br.com.sinergia.Sinergia.repository.UsuarioRepository;
import br.com.sinergia.Sinergia.service.UsuarioService;
import io.swagger.annotations.Api;

/**
 * @author Leonardo
 * @version 1.0
 */
@RestController
@RequestMapping("/usuarios")
@Api(tags = "Controlador de Usuario", description = "Utilitario de Usuarios")
@CrossOrigin("*")
public class UsuarioController {

	private @Autowired UsuarioRepository repository;
	private @Autowired UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodes() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarID(@PathVariable (value = "id") Long idUsuario) {
		return repository.findById(idUsuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> buscarNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeCompletoContainingIgnoreCase(nome));
	}

	@PostMapping("/cadastro")
	public ResponseEntity<Object> cadastrar(@Valid @RequestBody Usuario novoUsuario) {
		return service.cadastrarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Email existente, cadastre outro email!.");
				});

	}

	@PostMapping("/login")
	public ResponseEntity<CredenciaisDTO> logar(@Valid @RequestBody UsuarioLoginDTO usuarioParaAutenticar) {
		return service.pegarCredenciais(usuarioParaAutenticar);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario novoUsuario) {
		return service.atualizarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Necessário que passe um idUsuario valido para alterar!.");
				});

	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable (value = "id") Long idUsuario) {
		repository.deleteById(idUsuario);
	}

}
