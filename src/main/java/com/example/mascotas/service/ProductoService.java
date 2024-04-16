package com.example.mascotas.service;


import com.example.mascotas.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> getAllProducto();
    Optional<Producto> getProductoById(Long id);
    Producto createProducto(Producto producto);
    Producto updateProducto(Long id, Producto producto);
    void deleteProducto(Long id);
}