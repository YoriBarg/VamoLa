/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.ClienteController;
import interdisciplinar.Cliente;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import java.sql.*;
import static org.junit.Assert.*;
/**
 *
 * @author yurib
 */
public class TesteEditar {
@Test
public void testAtualizarCliente() throws SQLException {
    ClienteController controller = new ClienteController();
    
    Cliente cliente = new Cliente();
    cliente.setEmail("editar@teste.com");
    cliente.setNome("Nome Antigo");
    cliente.setCSenha("senha123");
    cliente.setNomeTime("flamengo");
    cliente.setPermissao(0);
    controller.salvarCliente(cliente);

    boolean atualizado = controller.alterarCliente("editar@teste.com", "Nome Atualizado", "senha123", "Time Novo");
    assertTrue("Falha ao atualizar cliente", atualizado);

    Cliente clienteAtualizado = controller.buscarCliente("editar@teste.com", "senha123");
    assertNotNull("Cliente não encontrado após atualização", clienteAtualizado);
    assertEquals("Nome não atualizado corretamente", "Nome Atualizado", clienteAtualizado.getNome());
    assertEquals("Time não atualizado corretamente", "Time Novo", clienteAtualizado.getNomeTime());

    controller.excluirCliente("editar@teste.com", "senha123");
}
}