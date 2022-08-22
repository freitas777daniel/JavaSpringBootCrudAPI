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


import crudModelo.model.Veiculo;
import crudModelo.repository.VeiculoRepository;

@CrossOrigin
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculorepository;
	
	@GetMapping
	public List<Veiculo> listar() {
		return veiculorepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Veiculo PegarId(@PathVariable Long id) {
		return veiculorepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar (@RequestBody Veiculo veiculo) {
		return veiculorepository.save(veiculo);
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar (@PathVariable Long id, @RequestBody Veiculo veiculo) {
		veiculo.setId(id);
		return veiculorepository.save(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public void excluir (@PathVariable Long id) {
		veiculorepository.delete(veiculorepository.findById(id).get());
	}
	
}
