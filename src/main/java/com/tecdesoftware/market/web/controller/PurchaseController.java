package com.tecdesoftware.market.web.controller;

import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase Controller", description = "Manage purchase operations")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(
            summary = "Get all purchases",
            description = "Returns a list of all registered purchases"
    )
    @ApiResponse(responseCode = "200", description = "Successful")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    @Operation(
            summary = "Get purchases by client ID",
            description = "Returns a list of purchases for a specific client"
    )
    @ApiResponse(responseCode = "200", description = "Purchases found for client")
    @ApiResponse(responseCode = "404", description = "No purchases found for client")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID of the client whose purchases are to be retrieved",
                    example = "5",
                    required = true)
            @PathVariable("idClient") Integer clientId) {
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(
            summary = "Save a new purchase",
            description = "Registers a new purchase and returns the created object",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "clienteId": 1,
                                                "productos": [
                                                    {
                                                        "productoId": 2,
                                                        "cantidad": 3,
                                                        "total": 150.0
                                                    }
                                                ],
                                                "medioPago": "Tarjeta",
                                                "comentario": "Compra en línea",
                                                "estado": true
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Purchase successfully created")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Purchase> save(
            @RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
