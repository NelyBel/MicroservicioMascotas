package com.example.mascotas.service;


import com.example.mascotas.model.Ventas;

import java.util.List;
import java.util.Optional;

public interface VentasService {
    List<Ventas> getAllVentas();
    Optional<Ventas> getVentasById(Long id);
    Ventas createVentas(Ventas ventas);
    Ventas updateVentas(Long id, Ventas ventas);
    void deleteVentas(Long id);
    Integer getVentasByDia(Integer dia);
    Integer getVentasByMes(Integer mes);
    Integer getVentasByAnnio(Integer annio);

}
