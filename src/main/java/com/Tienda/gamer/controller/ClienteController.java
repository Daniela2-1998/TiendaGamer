package com.Tienda.gamer.controller;

import com.Tienda.gamer.dto.request.ClienteConIdRequestDto;
import com.Tienda.gamer.dto.request.ClienteRequestDto;
import com.Tienda.gamer.dto.response.ClienteResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.service.ClienteServiceImp;
import com.Tienda.gamer.service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    // ------------------------------------   INYECCIÓN DE DEPENDENCIAS  ----------------------------------------------
    IClienteService service;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public ClienteController(ClienteServiceImp service){
        this.service = service;
    };

    // --------------------------------------------    MAPEOS    ------------------------------------------------------
    @GetMapping()
    public ResponseEntity<List<ClienteResponseDto>> obtenerClientes(){
        return new ResponseEntity<>(service.obtenerClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> obtenerClienteById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerClienteById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ClienteResponseDto> agregarCliente(@RequestBody @Valid ClienteRequestDto clienteRequestDto){
        return new ResponseEntity<>(service.agregarCliente(clienteRequestDto),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ClienteResponseDto> editarCliente(@RequestBody @Valid ClienteConIdRequestDto clienteRequestConIdDto){
        return new ResponseEntity<>(service.editarCliente(clienteRequestConIdDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> eliminarCliente(@PathVariable long id){
        return new ResponseEntity<>(service.eliminarCliente(id),HttpStatus.OK);
    }

}
