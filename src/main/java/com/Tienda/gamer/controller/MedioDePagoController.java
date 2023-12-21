package com.Tienda.gamer.controller;

import com.Tienda.gamer.dto.request.MedioDePagoConIdRequestDto;
import com.Tienda.gamer.dto.request.MedioDePagoRequestDto;
import com.Tienda.gamer.dto.response.MedioDePagoResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.service.IMedioDePagoService;
import com.Tienda.gamer.service.MedioDePagoServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mediosDePago")
public class MedioDePagoController {

    // ------------------------------------   INYECCIÓN DE DEPENDENCIAS  ----------------------------------------------
    IMedioDePagoService service;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public MedioDePagoController(MedioDePagoServiceImp service) {
        this.service = service;
    }


    // --------------------------------------------    MAPEOS    ------------------------------------------------------
    @GetMapping()
    public ResponseEntity <List<MedioDePagoResponseDto>> obtenerMediosDePago(){
        return new ResponseEntity<>(service.obtenerMediosDePago(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <MedioDePagoResponseDto> obtenerMedioDePagoById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerMedioDePagoById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity <MedioDePagoResponseDto> agregarMedioDePago(@RequestBody @Valid MedioDePagoRequestDto
                                                                                  medioDePagoRequestDto){
        return new ResponseEntity<>(service.agregarMedioDePago(medioDePagoRequestDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity <MedioDePagoResponseDto>  editarMedioDePago(@RequestBody @Valid MedioDePagoConIdRequestDto
                                                                                  medioDePagoConIdRequestDto){
        return new ResponseEntity<>(service.editarMedioDePago(medioDePagoConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <MensajeResponseDto> eliminarMedioDePago(@PathVariable long id){
        return new ResponseEntity<>(service.eliminarMedioDePago(id), HttpStatus.OK);
    }


}
