package com.br.devgustavo.dao.generic.jdbc.dao;

import com.br.devgustavo.domain.Cliente;

import java.util.List;

public interface IClienteDAO {

    Integer insert(Cliente cliente) throws Exception;
    Integer update(Cliente cliente) throws Exception;
    Cliente find(String codigo) throws Exception;
    List<Cliente> findAll() throws Exception;
    Integer delete(Integer id) throws Exception;

}
