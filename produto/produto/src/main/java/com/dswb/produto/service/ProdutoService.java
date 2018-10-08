package com.dswb.produto.service;

import com.dswb.produto.dao.ProdutoDAO;
import com.dswb.produto.model.Produto;
import java.sql.SQLException;
import java.util.List;

public class ProdutoService {

    public List<Produto> listarProdutos() throws SQLException {
        ProdutoDAO prod = new ProdutoDAO();
        List<Produto> lista = prod.listProduto();
        return lista;
    }

    public Produto pegarProduto(int id) throws SQLException {
        ProdutoDAO prodDAO = new ProdutoDAO();
        Produto produto = prodDAO.getProduto(id);
        System.out.println(produto.getNome());
        return produto;
    }

}
