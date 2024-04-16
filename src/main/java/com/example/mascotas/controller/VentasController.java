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
import com.example.mascotas.model.Ventas;
import com.example.mascotas.service.VentasService;

@RestController
@RequestMapping("/ventas")
public class VentasController {


    private static final Logger log = LoggerFactory.getLogger(VentasController.class);

    @Autowired
    private VentasService ventasService;

    @GetMapping
    public List<Ventas> getAllVentas(){
        log.info("GET /ventas");
        log.info("retornando todas las ventas");
        return ventasService.getAllVentas();
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentasById(@PathVariable Long id) {
        Optional<Ventas> ventas = ventasService.getVentasById(id);

        if (ventas.isEmpty()){
            log.error("********* No se encontro la venta con ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("********* No se encontro la venta con ID " + id));
        }
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<Object> createVentas(@RequestBody Ventas ventas){
        Ventas createVentas = ventasService.createVentas(ventas);
       
        if (createVentas == null){
            log.error("***** Error al crear la venta {}", ventas);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Error al crear la venta"));
        }
        return ResponseEntity.ok(createVentas);
   
    }

    @PutMapping("/{id}")
    public Ventas updateVentas(@PathVariable Long id, @RequestBody Ventas ventas){
        return ventasService.updateVentas(id, ventas);
    }

    @DeleteMapping("/{id}")
    public void deleteVentas(@PathVariable Long id){
        ventasService.deleteVentas(id);
    }


    @GetMapping("/ventaDia/{dia}")
    public Integer getVentasByDia(@PathVariable Integer dia) {
    
        return ventasService.getVentasByDia(dia);
    }

    @GetMapping("/ventaMes/{mes}")
    public Integer getVentasByMes(@PathVariable Integer mes) {
    
        return ventasService.getVentasByMes(mes);
    }

    @GetMapping("/ventaAnnio/{annio}")
    public Integer getVentasByAnnio(@PathVariable Integer annio) {
    
        return ventasService.getVentasByAnnio(annio);
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
