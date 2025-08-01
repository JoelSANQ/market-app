package com.tecdesoftware.market.persistence.mapper;

import com.tecdesoftware.market.persistence.entity.Compra;
import com.tecdesoftware.market.domain.Purchase;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clienteId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toPurchase(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true),
            @Mapping(target = "idCompra", ignore = true) // ← evita el error
    })
    Compra toCompra(Purchase purchase);
}
