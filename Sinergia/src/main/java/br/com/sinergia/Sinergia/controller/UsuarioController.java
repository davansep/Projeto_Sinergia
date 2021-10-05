package br.com.sinergia.Sinergia.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.sinergia.Sinergia.model.Usuario;
import br.com.sinergia.Sinergia.repository.UsuarioRepository;

/**
 * @author Leonardo
 * @version 1.0
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	// buscarTodesUsuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// buscarPorId_Usuario
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id_usuario) {
		return repository.findById(id_usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// buscarPorNome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome_completo) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome_completo));
	}

	// salvarUsuario
	@PostMapping
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}

	// atualizarUsuario
	@PutMapping
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novoUsuario));
	}

	// deletarUsuario
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id_usuario) {
		repository.deleteById(id_usuario);
	}

}
