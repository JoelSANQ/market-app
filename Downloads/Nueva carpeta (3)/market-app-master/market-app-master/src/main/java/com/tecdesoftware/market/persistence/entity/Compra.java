package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    private String nombre;

    @Column(name = "id_cliente")
    private Integer idCliente;

    private String fecha;

    @Column(name = "medio_pago")
    private Double medioPago;

    private Integer comentario;

    private Boolean estado;

    //Relación con la entidad cliente: Muchas compras a un cliente
    @ManyToOne
    //No quiero que se modifique la entidad cliente, solo relacionarlo
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //Una compra con muchos productos
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<CompraProducto> productos;  // <-- Cambié 'Productos' a 'productos'

    // Getters y Setters

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(Double medioPago) {
        this.medioPago = medioPago;
    }

    public Integer getComentario() {
        return comentario;
    }

    public void setComentario(Integer comentario) {
        this.comentario = comentario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    // Getters y setters para productos

    public List<CompraProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
