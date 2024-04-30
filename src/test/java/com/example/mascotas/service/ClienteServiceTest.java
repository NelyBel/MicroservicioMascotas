package com.example.mascotas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.mascotas.model.Cliente;
import com.example.mascotas.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepositoryMock;

    @Test
    public void guardarClienteTest() {

        Cliente cliente = new Cliente();
        cliente.setNombre("Pepe");
        cliente.setApellido("Mujica");

        when(clienteRepositoryMock.save(any())).thenReturn(cliente);

        Cliente resultado = clienteService.createCliente(cliente);
     

        assertEquals("Mujica", resultado.getApellido());
    }
    
}
