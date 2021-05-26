package br.com.sistemas.catalago.service;

import br.com.sistemas.catalago.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    public List<Produto> findAll();
    public Optional<Produto> findById(Long id);

    public Produto save(Produto produto);
    public void delete(Long id);
}
