package br.com.sinergia.Sinergia.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.sinergia.Sinergia.model.Tema;
import br.com.sinergia.Sinergia.repository.TemaRepository;

/**
 * @author Team Sinergia
 * @version 1.0
 */
@RestController
@RequestMapping("/temas")
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
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	/**
	 * @author Joao
	 * @return FindById, BuscarPeloId
	 * @since 1.0
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable Long idTema) {
		return repository.findById(idTema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * @author Leonardo
	 * @return FindByTema, BuscarPeloTema
	 * @since 1.0
	 */
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<Tema>> getByTema(@PathVariable String tema) {
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
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long idTema) {
		repository.deleteById(idTema);
	}

}
