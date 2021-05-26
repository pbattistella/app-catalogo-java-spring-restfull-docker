package br.com.sistemas.catalago.Service;

import br.com.sistemas.catalago.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    public Optional<Pedido> findById(Long id);
    public List<Pedido> findAll();

    public Pedido save(Pedido pedido);
    public void deleteById(Long id);

}
