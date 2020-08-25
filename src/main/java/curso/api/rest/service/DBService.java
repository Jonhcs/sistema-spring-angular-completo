package curso.api.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import curso.api.rest.model.Telefone;
import curso.api.rest.model.Usuario;
import curso.api.rest.repositoy.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	public void instanciateTestDatabase() {
		List<Telefone> tels = new ArrayList<>();
		
		Usuario usuario = new Usuario(null, "admin", pe.encode("admin"), "Jhonatan", "10978229401",tels);
		
		Telefone telefone = new Telefone();
		telefone.setNumero("41987859201");
		telefone.setUsuario(usuario);
		tels.add(telefone);
		
		usuarioRepository.save(usuario);
	}
}
