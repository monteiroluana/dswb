package com.dswb.produto.controller;

import com.dswb.produto.model.Produto;
import com.dswb.produto.service.ProdutoService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
    public ModelAndView obter(@PathVariable("id") int id)throws SQLException {
        ProdutoService service = new ProdutoService();
        Produto produto = service.pegarProduto(id);
        return new ModelAndView("mostrarProduto").addObject("produto", produto);
    }
}