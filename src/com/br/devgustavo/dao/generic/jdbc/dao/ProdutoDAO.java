package com.br.devgustavo.dao.generic.jdbc.dao;

import com.br.devgustavo.dao.generic.jdbc.DBConnection;
import com.br.devgustavo.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{

    @Override
    public Integer insert(Produto produto) throws Exception {

        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "INSERT INTO tb_produtos (nome, price, qtd_estoque) " +
                     "VALUES (?, ?, ?)";
        try {
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setString(1,produto.getNome());
            stm.setDouble(2,produto.getPrice());
            stm.setInt(3,produto.getQtd_estoque());
            return stm.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
    }

    @Override
    public Integer update(Produto produto) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "UPDATE tb_produtos " +
                     "SET nome = ?, price = ?, qtd_estoque = ? " +
                     "WHERE id = ?";
        try {
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setString(1,produto.getNome());
            stm.setDouble(2,produto.getPrice());
            stm.setInt(3,produto.getQtd_estoque());
            stm.setInt(4,produto.getId());
            return stm.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "DELETE FROM tb_produtos WHERE id = ?";
        try {
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            return stm.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
    }

    @Override
    public List<Produto> findAll() throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        String sql = "SELECT * FROM tb_produtos";
        List<Produto> produtoList = new ArrayList<>();
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                produto = new Produto(rs.getString("nome"),rs.getDouble("price"),rs.getInt("qtd_estoque"));
                produtoList.add(produto);
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,rs);
        }
        return produtoList;
    }

    @Override
    public Produto findById(Integer id) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        String sql = "SELECT * FROM tb_produtos WHERE id = ?";
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            rs = stm.executeQuery();
            if(rs.next()){
                produto = new Produto(rs.getString("nome"),rs.getDouble("price"),rs.getInt("qtd_estoque"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,rs);
        }
        return produto;
    }
}
