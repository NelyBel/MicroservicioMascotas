package com.example.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mascotas.model.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long>{
   
@Query( value = "select Sum(total) FROM ventas where  EXTRACT(DAY FROM fecha_venta) =  ?", 
nativeQuery = true)
Integer ventasPorDia(Integer dia);

@Query( value = "select Sum(total) FROM ventas where  EXTRACT(MONTH FROM fecha_venta) =  ?", 
nativeQuery = true)
Integer ventasPorMes(Integer mes);

@Query( value = "select Sum(total) FROM ventas where  EXTRACT(YEAR FROM fecha_venta) =  ?", 
nativeQuery = true)
Integer ventasPorAnnio(Integer annio);


}
