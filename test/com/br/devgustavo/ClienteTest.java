package com.br.devgustavo;

import com.br.devgustavo.dao.generic.jdbc.dao.ClienteDAO;
import com.br.devgustavo.domain.Cliente;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testInsert() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("10","Bob Brown");
        int result = clienteDAO.insert(cliente);
        assertTrue(result == 1);

        clienteDAO.delete(1);
    }
    @Test
    public void testUpdate() throws Exception{
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("10","Bob Brown");
        int result = clienteDAO.insert(cliente);
        assertTrue(result == 1);

        Cliente clienteUpdate = new Cliente("10", "Gustavo Paiva");
        clienteUpdate.setId(2);
       int resultQ = clienteDAO.update(clienteUpdate);
        assertTrue(resultQ == 1);

        clienteDAO.delete(2);
    }
    @Test
    public void testFind() throws Exception{
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("10","Bob Brown");
        int result = clienteDAO.insert(cliente);
        assertTrue(result == 1);

       Cliente clienteResult = clienteDAO.find("10");
       assertEquals("Bob Brown", clienteResult.getNome());

        clienteDAO.delete(3);

    }
    @Test
    public void testFindAll() throws Exception{
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("10","Bob Brown");
        int result = clienteDAO.insert(cliente);
        assertTrue(result == 1);

        Cliente cliente2 = new Cliente("11","Jean Mago");
        int result2 = clienteDAO.insert(cliente);
        assertTrue(result2 == 1);

        List<Cliente> clienteList = clienteDAO.findAll();
        assertNotNull(clienteList);
        assertEquals(2, clienteList.size());

        clienteDAO.delete(4);
        clienteDAO.delete(5);
    }
    @Test
    public void testDelete() throws Exception{
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente("10","Bob Brown");
        int result = clienteDAO.insert(cliente);
        assertTrue(result == 1);

        int resultDelete = clienteDAO.delete(6);
        assertTrue(resultDelete == 1);
    }
}
