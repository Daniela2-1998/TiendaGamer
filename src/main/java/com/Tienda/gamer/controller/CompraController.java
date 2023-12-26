package com.Tienda.gamer.controller;

import com.Tienda.gamer.dto.request.CompraConIdRequestDto;
import com.Tienda.gamer.dto.request.CompraRequestDto;
import com.Tienda.gamer.dto.response.CompraResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.service.CompraServiceImp;
import com.Tienda.gamer.service.ICompraService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compras")
public class CompraController {

    // ------------------------------------   INYECCIÓN DE DEPENDENCIAS  ----------------------------------------------
    ICompraService service;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public CompraController(CompraServiceImp service) {
        this.service = service;
    }



    // --------------------------------------------    MAPEOS    ------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<CompraResponseDto>> obtenerCompras(){
        return new ResponseEntity<>(service.obtenerCompras(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <CompraResponseDto> obtenerCompraById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerCompraById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity <CompraResponseDto> agregarCompra(@RequestBody @Valid CompraRequestDto compraRequestDto){
        return new ResponseEntity<>(service.agregarCompra(compraRequestDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity <CompraResponseDto> editarCompra(@RequestBody @Valid CompraConIdRequestDto compraConIdRequestDto){
        return new ResponseEntity<>(service.editarCompra(compraConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <MensajeResponseDto> eliminarCompra(@PathVariable long id){
        return new ResponseEntity<>(service.eliminarCompra(id), HttpStatus.OK);
    }



}
