package br.com.sistemas.catalago.Service;

import br.com.sistemas.catalago.model.Produto;
import br.com.sistemas.catalago.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto save(Produto produto) {
        try{
            return produtoRepository.save(produto);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        try{
            produtoRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("Erro ao deletar o produto." + e.getMessage());
        }
    }
}
