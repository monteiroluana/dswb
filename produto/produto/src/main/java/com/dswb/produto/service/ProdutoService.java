package com.dswb.produto.service;

import com.dswb.produto.dao.ProdutoDAO;
import com.dswb.produto.model.Produto;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        System.out.println("serviço: " + produto.getNome());
        return produto;
    }

    public static void deletarProduto(Produto produto) throws SQLException {
        ProdutoDAO prodDAO = new ProdutoDAO();
        boolean result = prodDAO.deleteProduto(produto);
        System.out.println("DELETAR> " + result);
    }

    public void cadastrarProduto(Produto produto) throws SQLException, ClassNotFoundException {
        ProdutoDAO prodDAO = new ProdutoDAO();
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        produto.setDt_cadastro(tm);

        boolean result = prodDAO.setProduto(produto);
        System.out.println("INSERIR> " + result);

    }

}
