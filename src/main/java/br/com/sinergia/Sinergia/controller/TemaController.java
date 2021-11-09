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

import br.com.sinergia.Sinergia.model.Tema;
import br.com.sinergia.Sinergia.repository.TemaRepository;
import io.swagger.annotations.Api;

/**
 * @author Team Sinergia
 * @version 1.0
 */
@RestController
@RequestMapping("/temas")
@Api(tags = "Controlador de Tema", description = "Utilitario de Temas")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	private TemaRepository repository;

	/**
	 * @author Victor
	 * @return FindAll, BuscarTodosOsTemas
	 * @since 1.0
	 */
	@GetMapping
	public ResponseEntity<List<Tema>> buscarTodos() {
		return ResponseEntity.ok(repository.findAll());
	}

	/**
	 * @author Joao
	 * @return FindById, BuscarPeloId
	 * @since 1.0
	 */
	@GetMapping("/{id_tema}")
	public ResponseEntity<Tema> buscarID(@PathVariable(value = "id_tema") Long idTema) {
		return repository.findById(idTema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * @author Leonardo
	 * @return FindByTema, BuscarPeloTema
	 * @since 1.0
	 */
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<Tema>> buscarTema(@PathVariable String tema) {
		return ResponseEntity.ok(repository.findAllByTemaContainingIgnoreCase(tema));
	}

	/**
	 * @author Priscila
	 * @return Salvar tema
	 * @since 1.0
	 */
	@PostMapping
	public ResponseEntity<Tema> postar(@Valid @RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	/**
	 * @author Priscila
	 * @return Atualizar tema
	 * @since 1.0
	 */
	@PutMapping
	public ResponseEntity<Tema> atualizar(@Valid @RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}

	/**
	 * @author Priscila
	 * @return Deletar tema
	 * @since 1.0
	 */
	@DeleteMapping("/{id_tema}")
	public void deletar(@PathVariable(value = "id_tema") Long idTema) {
		repository.deleteById(idTema);
	}

}
