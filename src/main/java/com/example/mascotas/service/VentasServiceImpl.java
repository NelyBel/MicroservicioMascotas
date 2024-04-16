package com.example.mascotas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mascotas.model.Ventas;
import com.example.mascotas.repository.VentasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VentasServiceImpl implements VentasService{
    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Optional<Ventas> getVentasById(Long id) {
        return ventasRepository.findById(id);
    }
 
    @Override
    public Ventas createVentas(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Long id, Ventas ventas){
        if(ventasRepository.existsById(id)){
            ventas.setId(id);
            return  ventasRepository.save(ventas);
        }else {
            return null;
        }
    }

    @Override
    public void deleteVentas(Long id){
        ventasRepository.deleteById(id);
    } 

    @Override
    public Integer getVentasByDia(Integer dia){
        return ventasRepository.ventasPorDia(dia);
    } 
    @Override
    public Integer getVentasByMes(Integer mes){
        return ventasRepository.ventasPorMes(mes);
    } 
    @Override
    public Integer getVentasByAnnio(Integer annio){
        return ventasRepository.ventasPorAnnio(annio);
    } 


}
