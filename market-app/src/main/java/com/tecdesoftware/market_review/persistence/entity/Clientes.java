package com.tecdesoftware.market_review.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table (name= "productos")
public class Producto {
@Id
@GeneratedValue(Strategy= GenerationType.IDENTITY)
@Column(name="id_producto")

    private integer idProducto;
    private String nombre;

    @Column(name ="id_categoria")
    private Integer idCategoria;

    @Column(name ="codigo_barras")
    private Integer codigoBarras;

    @Column(name ="precio_venta")
    private Integer precioVenta;

    @Column(name ="cantidad_stock")
    private Integer cantidadStock;

    @Column(name ="cantidad_stock")
    
    private Boolean estado;

    public integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
