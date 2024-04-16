package com.example.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mascotas.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
