package com.tecdesoftware.market_review.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="categorias")
public class categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY   )
    @Column((name = "categorias")
    private Integer Idcategoria;

    private String descripcion;
    private Boolean estado;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdcategoria() {
        return Idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        Idcategoria = idcategoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
