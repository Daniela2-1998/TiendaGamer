package com.Tienda.gamer.controller;

import com.Tienda.gamer.dto.request.GeneroConIdRequestDto;
import com.Tienda.gamer.dto.request.GeneroRequestDto;
import com.Tienda.gamer.dto.response.GeneroResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.service.GeneroServiceImp;
import com.Tienda.gamer.service.IGeneroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    // ------------------------------------   INYECCIÓN DE DEPENDENCIAS  ----------------------------------------------
    IGeneroService service;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public GeneroController(GeneroServiceImp service) {
        this.service = service;
    }

    // --------------------------------------------    MAPEOS    ------------------------------------------------------

    @GetMapping()
    public ResponseEntity <List<GeneroResponseDto>> obtenerGeneros(){
        return new ResponseEntity<>(service.obtenerGeneros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <GeneroResponseDto> obtenerGeneroById(@PathVariable long id){
        return new ResponseEntity<>(service.obtenerGeneroById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity <GeneroResponseDto> agregarGenero(@RequestBody @Valid GeneroRequestDto generoRequestDto){
        return new ResponseEntity<>(service.agregarGenero(generoRequestDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity <GeneroResponseDto> editarGenero(@RequestBody @Valid GeneroConIdRequestDto generoConIdRequestDto){
        return new ResponseEntity<>(service.editarGenero(generoConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<MensajeResponseDto> eliminarGenero(@PathVariable long id){
            return new ResponseEntity<>(service.eliminarGenero(id), HttpStatus.OK);
        }

}
