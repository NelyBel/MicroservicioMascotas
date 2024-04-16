package com.example.mascotas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mascotas.model.Cliente;
import com.example.mascotas.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
 
    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente){
        if(clienteRepository.existsById(id)){
            cliente.setId_cliente(id);
            return  clienteRepository.save(cliente);
        }else {
            return null;
        }
    }

    @Override
    public void deleteCliente(Long id){
         clienteRepository.deleteById(id);
    } 

}
