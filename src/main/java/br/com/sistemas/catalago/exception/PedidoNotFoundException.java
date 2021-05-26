package br.com.sistemas.catalago.exception;

public class PedidoNotFoundException extends RuntimeException{

    public PedidoNotFoundException(Long id){
        super("Não foi possível encontrar o pedido com código: " + id);
    }
}
