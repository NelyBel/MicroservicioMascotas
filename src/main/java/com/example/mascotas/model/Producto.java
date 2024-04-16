package com.example.mascotas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @NotBlank(message = "No puede ingresar un nombre vacio")
    @Column(name= "NOMBRE_PRODUCTO")
    private String nombre;

    @NotNull(message = "No puede ingresar el precio vacio")
    @Column(name= "PRECIO")
    private Integer precio;

    @NotBlank(message = "No puede ingresar una descripcion vacia")
    @Column(name= "DESCRIPCION")
    private String descripcion;

     @NotNull(message = "No puede ingresar un codigo vacio")
    @Column(name= "COD_PRODUCTO")
    private Integer codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    

}
