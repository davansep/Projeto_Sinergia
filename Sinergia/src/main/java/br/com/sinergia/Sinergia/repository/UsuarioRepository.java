package br.com.sinergia.Sinergia.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sinergia.Sinergia.model.Usuario;

/**
 * @author Priscila
 * @version 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna email da tabela usuario
	 * 
	 * @param email
	 * @return Optional com Usuario
	 * @author Priscila
	 * @since 1.0
	 */
	public Optional<Usuario> findByEmail(String email);

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna nome da tabela usuario
	 * 
	 * @param nome
	 * @return List com Usuario
	 * @author Priscila
	 * @since 1.0
	 */
	public List<Usuario> findAllByNomeCompletoContainingIgnoreCase(String nome);
}
