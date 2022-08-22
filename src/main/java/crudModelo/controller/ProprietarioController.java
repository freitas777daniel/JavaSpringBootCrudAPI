package crudModelo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import crudModelo.model.Proprietario;
import crudModelo.repository.ProprietarioRepository;



@CrossOrigin
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@GetMapping
	public List<Proprietario> listar() {
		return proprietarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Proprietario PegarId(@PathVariable Long id) {
		return proprietarioRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario adicionar (@RequestBody Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}
	
	@PutMapping("/{id}")
	public Proprietario atualizar (@PathVariable Long id, @RequestBody Proprietario proprietario) {
		//proprietarioRepository.findById(id);
		proprietario.setId(id);
		return proprietarioRepository.save(proprietario);
	}
	
	@DeleteMapping("/{id}")
	public void excluir (@PathVariable Long id) {
		proprietarioRepository.delete(proprietarioRepository.findById(id).get());
	}
	
	
	
}
