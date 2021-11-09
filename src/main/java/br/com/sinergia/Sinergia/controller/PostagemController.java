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

import br.com.sinergia.Sinergia.model.Postagem;
import br.com.sinergia.Sinergia.repository.PostagemRepository;
import io.swagger.annotations.Api;

/**
 * @author Amanda
 * @version 1.0
 */
@RestController
@RequestMapping("/postagens")
@Api(tags = "Controlador de Postagem", description = "Utilitario de Postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> bucarTodos() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_postagem}")
	public ResponseEntity<Postagem> buscarID(@PathVariable(value = "id_postagem") Long idPostagem) {
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> buscarTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> postar(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> atualizar(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	@DeleteMapping("/{id_postagem}")
	public void deletar(@PathVariable(value = "id_postagem") Long idPostagem) {
		repository.deleteById(idPostagem);
	}

}
