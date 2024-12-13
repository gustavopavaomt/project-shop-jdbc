package com.br.devgustavo.dao.generic.jdbc;

import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private DBConnection(Connection connection){}

    public static Connection getInstance() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try{
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/loja_jdbc", "postgres","admin"
            );
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void closeConnection(Connection cnt, PreparedStatement stm, ResultSet res){
        try{
            if(cnt != null){
                cnt.close();
            }else if(stm != null){
                stm.close();
            }else if(res !=null){
                stm.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
