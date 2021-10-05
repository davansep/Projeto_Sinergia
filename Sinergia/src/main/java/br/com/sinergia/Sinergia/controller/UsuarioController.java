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

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long idUsuario) {
		return repository.findById(idUsuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeCompletoContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novoUsuario));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long idUsuario) {
		repository.deleteById(idUsuario);
	}

}
