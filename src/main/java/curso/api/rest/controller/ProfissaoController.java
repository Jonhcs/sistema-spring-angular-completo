package curso.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Profissao;
import curso.api.rest.repositoy.ProfissaoRepository;

@RestController
@RequestMapping("/profissoes")
@CrossOrigin
public class ProfissaoController {

	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Profissao>> mostratTodos() {
		List<Profissao> profissoes = profissaoRepository.findAll();
		return new ResponseEntity<List<Profissao>>(profissoes, HttpStatus.OK);
	}
	
}
