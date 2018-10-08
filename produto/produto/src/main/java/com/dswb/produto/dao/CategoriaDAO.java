package com.dswb.produto.dao;

import com.dswb.produto.conexao.Conexao;
import com.dswb.produto.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public List<Categoria> listCategoria() throws ClassNotFoundException, SQLException {

        String sql = "SELECT id, nome FROM categoria ORDER BY id ASC";

        List<Categoria> lista = new ArrayList();

        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        try {
            con = Conexao.obterConexao();
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));

                lista.add(categoria);
            }
        } catch (SQLException e) {

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
}
