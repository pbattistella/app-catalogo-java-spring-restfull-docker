package br.com.sistemas.catalago.repository;

import br.com.sistemas.catalago.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
