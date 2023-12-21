package com.Tienda.gamer.controller;

import com.Tienda.gamer.dto.request.PlataformaConIdRequestDto;
import com.Tienda.gamer.dto.request.PlataformaRequestDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.dto.response.PlataformaResponseDto;
import com.Tienda.gamer.service.IPlataformaService;
import com.Tienda.gamer.service.PlataformaServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plataformas")
public class PlataformaController {

    // ------------------------------------   INYECCIÓN DE DEPENDENCIAS  ----------------------------------------------
    IPlataformaService service;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public PlataformaController(PlataformaServiceImp service) {
        this.service = service;
    }

    // --------------------------------------------    MAPEOS    ------------------------------------------------------
    @GetMapping()
    public ResponseEntity <List<PlataformaResponseDto>> obtenerPlataformas(){
        return new ResponseEntity<>(service.obtenerPlataformas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlataformaResponseDto> obtenerPlataformaById(@PathVariable long id){
        return new ResponseEntity<> (service.obtenerPlataformaById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PlataformaResponseDto> agregarPlataforma(@RequestBody @Valid PlataformaRequestDto plataformaRequestDto){
        return new ResponseEntity<> (service.agregarPlataforma(plataformaRequestDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PlataformaResponseDto> editarPlataforma(@RequestBody @Valid PlataformaConIdRequestDto
                                                                              plataformaConIdRequestDto){
        return new ResponseEntity<> (service.editarPlataforma(plataformaConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> eliminarPlataforma(@PathVariable long id){
        return new ResponseEntity<> (service.eliminarPlataforma(id), HttpStatus.OK);
    }

}
