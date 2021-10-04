package br.com.sinergia.Sinergia.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sinergia.Sinergia.model.Tema;
import br.com.sinergia.Sinergia.repository.TemaRepository;

/**
 * @author Team Sinergia
 * @version 1.0
 */
@RestController
@RequestMapping("/tema")
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
}
