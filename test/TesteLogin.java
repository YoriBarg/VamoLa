
import controller.ClienteController;
import interdisciplinar.Cliente;
import org.junit.Test;
import java.sql.*;
import static org.junit.Assert.assertNull;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */
public class TesteLogin {
    @Test
public void testLoginInvalido() throws SQLException {
    ClienteController controller = new ClienteController();
    Cliente cliente = controller.buscarCliente("inexistente@email.com", "senhaerrada");
    assertNull("Login com credenciais inválidas deveria retornar null", cliente);
}
}
