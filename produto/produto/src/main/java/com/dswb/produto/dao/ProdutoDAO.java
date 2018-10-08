package com.dswb.produto.dao;

import com.dswb.produto.conexao.Conexao;
import com.dswb.produto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public List<Produto> listProduto() throws SQLException {

        String sql = "SELECT id, nome, descricao, preco_compra, preco_venda, quantidade, disponivel, dt_cadastro FROM produto";

        List<Produto> lista = new ArrayList();

        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        try {
            con = Conexao.obterConexao();
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_compra(rs.getFloat("preco_compra"));
                produto.setPreco_venda(rs.getFloat("preco_venda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDt_cadastro(rs.getTimestamp("dt_cadastro"));
                produto.setDisponivel(rs.getBoolean("disponivel"));

                lista.add(produto);
            }

        } catch (Exception e) {

        } finally {
            if (con != null) {
                con.close();
            }
            if (p != null) {
                p.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return lista;
    }

    public Produto getProduto(int id) throws SQLException {
        String sql = "SELECT id, nome, descricao, preco_compra, preco_venda, quantidade, disponivel, dt_cadastro FROM produto WHERE id = ?";
        Produto produto = new Produto();

        Connection conn;
        try {
            conn = Conexao.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_compra(rs.getFloat("preco_compra"));
                produto.setPreco_venda(rs.getFloat("preco_venda"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setDt_cadastro(rs.getTimestamp("dt_cadastro"));
                produto.setDisponivel(rs.getBoolean("disponivel"));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return produto;

    }

    public boolean setProduto(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO produto (nome, descricao, preco_compra, preco_venda, quantidade, disponivel, dt_cadastro) VALUES (?,?,?,?,?,?,?)";

        Connection con = null;
        PreparedStatement p = null;

        try {
            con = Conexao.obterConexao();
            p = con.prepareStatement(sql);

            p.setString(1, produto.getNome());
            p.setString(2, produto.getDescricao());
            p.setFloat(3, produto.getPreco_compra());
            p.setFloat(4, produto.getPreco_venda());
            p.setInt(5, produto.getQuantidade());
            p.setBoolean(6, produto.getDisponivel());
            p.setTimestamp(7, produto.getDt_cadastro());

            p.execute();
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            if (con != null) {
                con.close();
            }
            if (p != null) {
                p.close();
            }
        }

    }

    public boolean updateProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome =?, descricao =?, preco_compra =?, preco_venda =?, quantidade =?, disponivel =? WHERE id = ?";

        Connection con = null;
        PreparedStatement p = null;

        try {
            con = Conexao.obterConexao();
            p = con.prepareStatement(sql);

            p.setString(1, produto.getNome());
            p.setString(2, produto.getDescricao());
            p.setFloat(3, produto.getPreco_compra());
            p.setFloat(4, produto.getPreco_venda());
            p.setInt(5, produto.getQuantidade());
            p.setBoolean(6, produto.getDisponivel());
            p.setInt(7, produto.getId());

            p.execute();
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            if (con != null) {
                con.close();
            }
            if (p != null) {
                p.close();
            }
        }

    }

    public boolean deleteProduto(Produto produto) throws SQLException {
        String sql = "DELETE FROM produto WHERE id=?";

        Connection con = null;
        PreparedStatement p = null;

        try {
            con = Conexao.obterConexao();
            p = con.prepareStatement(sql);

            p.setInt(1, produto.getId());

            p.execute();
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            if (con != null) {
                con.close();
            }
            if (p != null) {
                p.close();
            }
        }

    }

}
