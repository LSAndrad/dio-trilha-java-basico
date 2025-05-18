package java.spring.fornecedores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.spring.fornecedores.model.Fornecedor;
import java.spring.fornecedores.service.FornecedoresService;

@RestController
@RequestMapping("fornecedor")
public class FornecedoresRestController {

	@Autowired
	private FornecedoresService fornecedoresService;

	@GetMapping
	public ResponseEntity<Iterable<Fornecedor>> buscarTodos() {
		return ResponseEntity.ok(fornecedoresService.buscarTodos());
	}

	// Resgatar um fornecedor pelo seu ID
	// Como saber todos os IDs? é necessário criar um endpoint que retorna a lista com todos os IDs disponíveis
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(fornecedoresService.buscarPorId(id));
	}

	@GetMapping("/lista-ids")
	public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(fornecedoresService.getAllIds());
	}

	//Criar novos fornecedores
	@PostMapping
	public ResponseEntity<Fornecedor> inserir(@RequestBody Fornecedor fornecedor) {
		fornecedoresService.inserir(fornecedor);
		return ResponseEntity.ok(fornecedor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		fornecedoresService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
