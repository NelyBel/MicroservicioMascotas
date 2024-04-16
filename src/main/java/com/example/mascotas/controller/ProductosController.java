package com.example.mascotas.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mascotas.model.Producto;
import com.example.mascotas.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductosController {


    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProducto(){
        log.info("GET /Producto");
        log.info("retornando todos los productos");
        return productoService.getAllProducto();
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.getProductoById(id);

        if (producto.isEmpty()){
            log.error("********* No se encontro el productos con ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("********* No se encontro el productos con ID " + id));
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Object> createProducto(@RequestBody Producto producto){
        Producto createProducto = productoService.createProducto(producto);
       
        if (createProducto == null){
            log.error("***** Error al crear el productos {}", producto);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Error al crear el productos"));
        }
        return ResponseEntity.ok(createProducto);
   
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        return productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
    }



    static class ErrorResponse {
        private final String message;

        public ErrorResponse(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }

    }
}
