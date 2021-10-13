package br.com.sinergia.Sinergia.security;

import java.util.Optional;

import br.com.sinergia.Sinergia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sinergia.Sinergia.model.Usuario;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	private @Autowired UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> objetoOptional = repositorio.findByEmail(username);

		if (objetoOptional.isPresent()) {
			return new UserDetailsImplements(objetoOptional.get());
		} else {
			throw new UsernameNotFoundException(username + " Não existe!");
		}

	}

}