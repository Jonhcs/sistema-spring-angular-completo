package curso.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.ObjetoErro;
import curso.api.rest.model.Usuario;
import curso.api.rest.repositoy.UsuarioRepository;

@RestController
@RequestMapping("/recuperar")
@CrossOrigin
public class RecuperarController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<ObjetoErro> recuperarEmail(@RequestBody Usuario usuario) {
		 
		Usuario usuarioEncontrado = usuarioRepository.findUserByLogin(usuario.getLogin());
		ObjetoErro error = new ObjetoErro();
		
		if (usuarioEncontrado == null) {
			
			error.setCode("404");
			error.setError("Usuário Não Exsite");
			
		}else {
			error.setCode("200");
			error.setError("Email enviado com sucesso, Email: " + usuario.getLogin());
		}
		
		return new ResponseEntity<ObjetoErro>(error, HttpStatus.OK);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
}
