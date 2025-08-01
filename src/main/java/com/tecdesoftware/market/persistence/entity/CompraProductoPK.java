package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompraProductoPK {

    @Column (name = "id_compra")
    private Integer idCompra;

    @Column (name = "id_producto")
    private Integer producto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        producto = producto;
    }
}