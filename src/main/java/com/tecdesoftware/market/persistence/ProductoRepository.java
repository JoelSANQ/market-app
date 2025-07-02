package com.tecdesoftware.market.persistence;

import com.tecdesoftware.market.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Le dice a Spring que este repositorio se conecta con la DB
@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //Me va a dar todos los productos de mi DB
    public List<Producto> getAll() {
        productoCrudRepository.findAll();
        //Convirtiendo un Iterable<t> a una lista de productos List<Producto>
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos (int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //Obtener un producto dado el id
    public Optional<Producto> findByIdP(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    //Guardar Prodicto
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    //Borrar producto
    public void delete(Producto producto) {
        productoCrudRepository.delete(producto);
    }
}
