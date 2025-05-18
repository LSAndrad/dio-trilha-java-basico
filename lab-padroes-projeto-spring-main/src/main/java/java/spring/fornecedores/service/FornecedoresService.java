package java.spring.fornecedores.service;

import java.spring.fornecedores.model.Fornecedor;

public interface FornecedoresService {

	Iterable<Fornecedor> buscarTodos();

	Fornecedor buscarPorId(Long id);

	void inserir(Fornecedor fornecedor);

	void atualizar(Long id, Fornecedor fornecedor);

	void deletar(Long id);

}
