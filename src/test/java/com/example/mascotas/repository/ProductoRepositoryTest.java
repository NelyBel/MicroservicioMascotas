package com.example.mascotas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.mascotas.model.Producto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoRepositoryTest {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Test
    public void guardarProductoTest() {
        Producto producto = new Producto();
        producto.setNombre("Hueso");
        producto.setPrecio(4990);
        producto.setDescripcion("Elemento para morder");
        producto.setCodigo(1002);
        Producto resultado = productoRepository.save(producto);

        assertNotNull(resultado.getId());
        assertEquals("Hueso", resultado.getNombre());
        assertEquals(4990, resultado.getPrecio());
        assertNotNull(resultado.getDescripcion(), "Desc");
        assertEquals(1002, resultado.getCodigo());
    }
}
