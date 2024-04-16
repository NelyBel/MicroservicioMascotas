package com.example.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mascotas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
