package br.com.sistemas.catalago.exception;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException(Long id){
        super("Não foi possível encontrar o produto com código: " + id);
    }
}
