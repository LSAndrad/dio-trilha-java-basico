package java.spring.fornecedores.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

}