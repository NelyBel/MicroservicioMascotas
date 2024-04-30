package com.example.mascotas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.mascotas.model.Cliente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void guardarClienteTest() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Pedro");
        cliente.setApellido("Pascal");

        Cliente resultado = clienteRepository.save(cliente);

        assertNotNull(resultado.getId_cliente());
        assertEquals("Pedro", resultado.getNombre());
    }


    
}
