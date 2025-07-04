/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.ClienteController;
import interdisciplinar.Cliente;
import org.junit.Test;
import java.sql.*;
import static org.junit.Assert.*;
/**
 *
 * @author yurib
 */
public class TestePermisssão {
    @Test
public void testPermissaoAcesso() throws SQLException {
    Cliente cliente = new Cliente();
    cliente.setEmail("admin@teste.com");
    cliente.setNome("Admin");
    cliente.setCSenha("admin123");
    cliente.setPermissao(1); // administrador

    ClienteController controller = new ClienteController();
    controller.salvarCliente(cliente);

    Cliente resultado = controller.buscarCliente("admin@teste.com", "admin123");
    assertNotNull("Usuário administrador não encontrado", resultado);
    assertEquals("Permissão não corresponde", 1, resultado.getPermissao());

    controller.excluirCliente("admin@teste.com", "admin123");
}
}
