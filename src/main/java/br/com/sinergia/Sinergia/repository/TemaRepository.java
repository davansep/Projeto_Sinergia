package br.com.sinergia.Sinergia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sinergia.Sinergia.model.Tema;

/**
 * @author Amanda
 * @version 1.0
 */
@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	/**
	 * Método para buscar pela coluna 'tema' na tabela 'tema'.
	 * 
	 * @author Amanda
	 * @param tema
	 * @return lista com tema
	 * @since 1.0
	 */
	public List<Tema> findAllByTemaContainingIgnoreCase(String tema);

	/**
	 * Método para buscar pela coluna 'subTema' na tabela 'Tema'.
	 * 
	 * @author Victor
	 * @param subTema
	 * @return lista com subTema
	 * @since 1.0
	 */
	public List<Tema> findAllBySubTemaContainingIgnoreCase(String subTema);

}
