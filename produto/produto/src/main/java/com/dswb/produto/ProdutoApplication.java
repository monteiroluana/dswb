package com.dswb.produto;

import com.dswb.produto.dao.CategoriaDAO;
import com.dswb.produto.dao.ProdutoDAO;
import com.dswb.produto.model.Categoria;
import com.dswb.produto.model.Produto;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(ProdutoApplication.class, args);
        //inserirProd();
    }

    public static void listarCateg() throws ClassNotFoundException, SQLException {
        //teste 01 listCategoria
        CategoriaDAO categ = new CategoriaDAO();
        List<Categoria> lista = categ.listCategoria();
        System.out.println("CATEGORIAS");
        for (Categoria categoria : lista) {
            System.out.println(categoria.getId() + " | " + categoria.getNome());
        }
    }

    public static void listarProd() throws SQLException {
        //teste 02 listProdutosa
        ProdutoDAO prod = new ProdutoDAO();
        List<Produto> listaP = prod.listProduto();
        System.out.println("\n PRODUTOS");
        for (Produto produto : listaP) {
            System.out.println(produto.getId()+" | "+produto.getNome() + " | " + produto.getDt_cadastro());
        }
    }

    public static void inserirProd() throws SQLException, ClassNotFoundException {
        ProdutoDAO prodDAO = new ProdutoDAO();
        Produto prod = new Produto();

        prod.setNome("produto 07");
        prod.setDescricao("descricao do produto 07");
        prod.setDisponivel(true);
        prod.setPreco_compra(10);
        prod.setPreco_venda(13);
        prod.setQuantidade(100);

        Timestamp tm = new Timestamp(System.currentTimeMillis());
        prod.setDt_cadastro(tm);

        boolean result = prodDAO.setProduto(prod);
        System.out.println("INSERIR> " + result);
    }

    public static Produto pegarProduto(int id) throws SQLException {
        ProdutoDAO prodDAO = new ProdutoDAO();
        Produto prod = prodDAO.getProduto(id);
        System.out.println(prod.getNome());
        return prod;
    }

    public static void atualizarProduto(Produto produto) throws SQLException {
        ProdutoDAO prodDAO = new ProdutoDAO();
        boolean result = prodDAO.updateProduto(produto);
        System.out.println("ATUALIZAR> " + result);
    }
    
    public static void deletarProduto(Produto produto) throws SQLException{
     ProdutoDAO prodDAO = new ProdutoDAO();
        boolean result = prodDAO.deleteProduto(produto);
        System.out.println("DELETAR> " + result);
    }
}
