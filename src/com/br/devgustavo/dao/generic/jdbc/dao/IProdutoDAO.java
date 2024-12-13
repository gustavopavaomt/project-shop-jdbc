package com.br.devgustavo.dao.generic.jdbc.dao;

import com.br.devgustavo.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    Integer insert(Produto produto) throws Exception;
    Integer update(Produto produto) throws Exception;
    Integer delete(Integer id) throws Exception;
    List<Produto> findAll() throws  Exception;
    Produto findById(Integer id) throws Exception;

}
