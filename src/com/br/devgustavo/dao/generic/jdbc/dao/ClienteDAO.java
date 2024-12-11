package com.br.devgustavo.dao.generic.jdbc.dao;

import com.br.devgustavo.dao.generic.jdbc.DBConnection;
import com.br.devgustavo.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer insert(Cliente cliente) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "INSERT INTO tb_cliente(codigo, nome) " +
                     "VALUES (?, ?)";
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setString(1,cliente.getCodigo());
            stm.setString(2,cliente.getNome());
            return stm.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
    }

    @Override
    public Integer update(Cliente cliente) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "UPDATE tb_cliente " +
                    "SET codigo = ?, nome= ? " +
                    "WHERE id = ?";
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setString(1,cliente.getCodigo());
            stm.setString(2,cliente.getNome());
            stm.setInt(3, cliente.getId());
            return stm.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
    }

    @Override
    public Cliente find(String codigo) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        Cliente cliente = null;
        String sql = "SELECT * FROM tb_cliente WHERE codigo = ?";
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setString(1, codigo);
            res = stm.executeQuery();
            if(res.next()){
                cliente = new Cliente(res.getString("codigo"), res.getString("nome"));
                cliente.setId(res.getInt("id"));
            }

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
        return cliente;
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        Cliente cliente;
        List<Cliente> clienteList = new ArrayList<>();
        String sql = "select * from tb_cliente";
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            res = stm.executeQuery();

            while (res.next()){
                cliente = new Cliente(res.getString("codigo"), res.getString("nome"));
                cliente.setId(res.getInt("id"));
                clienteList.add(cliente);
            }


        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
        return clienteList;

    }

    @Override
    public Integer delete(Integer id) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "DELETE FROM tb_cliente WHERE id = ?";
        try{
            conn = DBConnection.getInstance();
            stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            return stm.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally {
            DBConnection.closeConnection(conn,stm,null);
        }
    }
}
