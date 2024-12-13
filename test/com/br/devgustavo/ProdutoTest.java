package com.br.devgustavo;

import com.br.devgustavo.dao.generic.jdbc.dao.IProdutoDAO;
import com.br.devgustavo.dao.generic.jdbc.dao.ProdutoDAO;
import com.br.devgustavo.domain.Produto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {


    @Test
    public void testInsert() throws Exception{
        IProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto("Notebook Dell",2000.00,10);
        int rowsAffects = produtoDAO.insert(produto);
        assertTrue(rowsAffects == 1);
    }
    @Test
    public void testUpdate() throws Exception{
        IProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto("Playstation 5", 4000.00,4);
        produto.setId(1);
        int rowsAffects = produtoDAO.update(produto);
        assertTrue(rowsAffects == 1);
    }
    @Test
    public void testFindAll() throws Exception {
        IProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto("Notebook Dell",2000.00,10);
        int rowsAffects = produtoDAO.insert(produto);
        assertTrue(rowsAffects == 1);

        List<Produto> produtoList = produtoDAO.findAll();
        assertTrue(produtoList.size() > 0);
    }
    @Test
    public void testFindById() throws Exception {
        IProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.findById(1);
        assertNotNull(produto);
    }
    @Test
    public void testDelete() throws Exception{
        IProdutoDAO produtoDAO = new ProdutoDAO();
        int resultDelete = produtoDAO.delete(2);
        assertTrue(resultDelete == 1);
    }

}
