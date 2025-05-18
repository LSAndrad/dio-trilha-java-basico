package java.spring.fornecedores.service.impl;

import java.spring.fornecedores.model.Fornecedor;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.spring.fornecedores.model.FornecedorRepository;
import java.spring.fornecedores.model.Endereco;
import java.spring.fornecedores.model.EnderecoRepository;
import java.spring.fornecedores.service.FornecedoresService;
import java.spring.fornecedores.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link FornecedoresService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class FornecedorServiceImpl implements FornecedoresService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Fornecedor> buscarTodos() {
		// Buscar todos os Clientes.
		return fornecedorRepository.findAll();
	}

	@Override
	public Fornecedor buscarPorId(Long id) {
		// Buscar Fornecedor por ID.
		Optional<Fornecedor> cliente = fornecedorRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Fornecedor fornecedor) {
		salvarClienteComCep(fornecedor);
	}

	@Override
	public void atualizar(Long id, Fornecedor fornecedor) {
		// Buscar Fornecedor por ID, caso exista:
		Optional<Fornecedor> clienteBd = fornecedorRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(fornecedor);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Fornecedor por ID.
		fornecedorRepository.deleteById(id);
	}

	private void salvarClienteComCep(Fornecedor fornecedor) {
		// Verificar se o Endereco do Fornecedor já existe (pelo CEP).
		String cep = fornecedor.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		fornecedor.setEndereco(endereco);
		// Inserir Fornecedor, vinculando o Endereco (novo ou existente).
		fornecedorRepository.save(fornecedor);
	}

}
