package com.dswb.produto.controller;

import com.dswb.produto.model.Produto;
import com.dswb.produto.service.ProdutoService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/listar")
    public ModelAndView listarProduto() throws SQLException {
        ProdutoService service = new ProdutoService();
        List<Produto> lista = service.listarProdutos();
        return new ModelAndView("inicial").addObject("produtos", lista);
    }

    @GetMapping("/prod/{id}")
    public ModelAndView obter(@PathVariable("id") int id) throws SQLException {
        ProdutoService service = new ProdutoService();
        Produto produto = service.pegarProduto(id);
        return new ModelAndView("mostrarProduto").addObject("produto", produto);
    }

    @RequestMapping(value = "/getProduto", method = RequestMethod.POST, params = "action=edit")
    public ModelAndView editar(@ModelAttribute("produto") Produto produto) throws SQLException {
        ProdutoService service = new ProdutoService();
        System.out.println(produto.getNome());
        produto = service.pegarProduto(produto.getId());
        return new ModelAndView("mostrarProduto").addObject("produto", produto);
    }

    
   /* @PostMapping(value="/getProduto", params="action=edit")
    public ModelAndView editar02(@ModelAttribute("produto")Produto produto) throws SQLException {
    	ProdutoService service = new ProdutoService();
    	produto = service.pegarProduto(produto.getId());
    	return new ModelAndView("mostrarProduto").addObject("produto", produto);
    }*/
    
    @GetMapping("/{id}")
    public ModelAndView excluir(@PathVariable("id") int id) throws SQLException{

        ProdutoService service = new ProdutoService();
        Produto produto = service.pegarProduto(id);
        service.deleteProduto(id);
        return new ModelAndView("GerenciarProdutos");
                
       // service.delete(id);

       // return findAll();
    }

}
