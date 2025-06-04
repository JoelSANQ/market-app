package com.tecdesoftware.market_review.persistence.entity;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private long celular;
    private String apellidos;
    @Column(name = "correo_electronico")
    private String correoelectronico;

    @OneToMany (mappedBy = "cliente")
    private List<Compra> compras;

    @OneToMany (mappedBy = "categorias")
    private List<weProducto> compras_productos;

    @OneToMany (mappedBy = "compras")
    private List<CompraProducto> compraProductos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }
}
