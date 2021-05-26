package br.com.sistemas.catalago.controller;

import br.com.sistemas.catalago.service.ProdutoServiceImpl;
import br.com.sistemas.catalago.exception.ProdutoNotFoundException;
import br.com.sistemas.catalago.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl produtoService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Produto> getProdutos(){
        return produtoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Produto getProduto(@PathVariable Long id){
        return produtoService.findById(id)
                .orElseThrow(()-> new ProdutoNotFoundException(id));
    }

    @PostMapping(value = "/", produces = "application/json")
    public Produto newProduto(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Produto replaceProduto(@RequestBody Produto produto, @PathVariable Long id){
        return produtoService.findById(id)
               .map(p ->{
                   p.setNome(produto.getNome());
                   p.setDescricao(produto.getDescricao());
                   p.setPreco(produto.getPreco());
                   return produtoService.save(p);
               })
                .orElseGet(() ->{
                        produto.setId(id);
                        return produtoService.save(produto);
                });
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteProduto(@PathVariable Long id){
        produtoService.delete(id);
    }
}
