package com.tecdesoftware.market_review.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompraProductoPK {
    @Column(name ="id_compra")
    private int idCompra;

    @Column(name ="id_producto")
    private int idProducto;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
