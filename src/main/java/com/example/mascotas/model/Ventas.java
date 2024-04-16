package com.example.mascotas.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "ID_VENTA")
    private Long id;

    @NotNull(message = "No puede ingresar un id vacio")
    @Column(name= "ID_PRODUCTO")
    private Long id_prod;

    @NotNull(message = "No puede ingresar un id vacio")
    @Column(name= "ID_CLIENTE")
    private Long id_cli;

    @NotNull(message = "No puede ingresar una cantidad vacia")
    @Column(name= "CANTIDAD")
    private Integer cantidad;

  
    @DateTimeFormat(pattern="dd-MM-yyyy")
    @Column(name= "FECHA_VENTA")
    private Date fecha_venta;

    @NotNull(message = "No puede ingresar un valor vacio")
    @Column(name= "TOTAL")
    private Integer total;


    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_prod() {
        return id_prod;
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public Long getId_cli() {
        return id_cli;
    }

    public void setId_cli(Long id_cli) {
        this.id_cli = id_cli;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    

}
