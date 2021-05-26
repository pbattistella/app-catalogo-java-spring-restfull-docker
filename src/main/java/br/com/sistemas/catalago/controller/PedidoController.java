package br.com.sistemas.catalago.controller;

import br.com.sistemas.catalago.service.PedidoServiceImpl;
import br.com.sistemas.catalago.exception.PedidoNotFoundException;
import br.com.sistemas.catalago.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoServiceImpl pedidoService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Pedido> getProdutos(){
        return pedidoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    private Pedido getPedido(@PathVariable Long id){
        return pedidoService.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

    @PostMapping(value = "/", produces = "application/json")
    public Pedido newPedido(@RequestBody Pedido pedido){
        return pedidoService.save(pedido);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Pedido replacePedido(@RequestBody Pedido pedido, @PathVariable Long id){
        return pedidoService.findById(id)
                .map(p ->{
                    p.setDescricao(pedido.getDescricao());
                    p.setDataPedido(pedido.getDataPedido());
                    return pedidoService.save(p);
                })
                .orElseGet(()->{
                    pedido.setId(id);
                    return pedidoService.save(pedido);
                });
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void delete(@PathVariable Long id){
        pedidoService.deleteById(id);
    }
}
