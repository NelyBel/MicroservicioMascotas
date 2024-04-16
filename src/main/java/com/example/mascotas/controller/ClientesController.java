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
import com.example.mascotas.model.Cliente;
import com.example.mascotas.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private static final Logger log = LoggerFactory.getLogger(ClientesController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllCliente(){
        log.info("GET /Cliente");
        log.info("retornando todos los clientes");
        return clienteService.getAllCliente();
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);

        if (cliente.isEmpty()){
            log.error("********* No se encontro el clientes con ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("********* No se encontro el clientes con ID " + id));
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente){
        Cliente createCliente = clienteService.createCliente(cliente);
       
        if (createCliente == null){
            log.error("***** Error al crear el clientes {}", cliente);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Error al crear el clientes"));
        }
        return ResponseEntity.ok(createCliente);
   
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente Cliente){
        return clienteService.updateCliente(id, Cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
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
