package br.com.sinergia.Sinergia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sinergia.Sinergia.model.Postagem;

/**
 * @author Priscila
 * @version 1.0
 */
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna titulo da tabela postagem
	 * 
	 * @param titulo
	 * @return List com Postagem
	 * @author Priscila
	 * @since 1.0
	 */
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
