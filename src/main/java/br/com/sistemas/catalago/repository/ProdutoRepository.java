package br.com.sistemas.catalago.repository;

import br.com.sistemas.catalago.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
