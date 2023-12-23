package com.Tienda.gamer.controller;

import com.Tienda.gamer.dto.request.JuegoConIdRequestDto;
import com.Tienda.gamer.dto.request.JuegoRequestDto;
import com.Tienda.gamer.dto.response.JuegoResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.service.IJuegoService;
import com.Tienda.gamer.service.JuegoServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("juegos")
public class JuegoController {

    // ------------------------------------   INYECCIÓN DE DEPENDENCIAS  ----------------------------------------------
    IJuegoService service;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------

    public JuegoController(JuegoServiceImp service) {
        this.service = service;
    }

    // --------------------------------------------    MAPEOS    ------------------------------------------------------

    @GetMapping()
    public ResponseEntity<List<JuegoResponseDto>> obtenerJuegos() {
        return new ResponseEntity<>(service.obtenerJuegos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoResponseDto> obtenerJuegoById(@PathVariable long id) {
        return new ResponseEntity<>(service.obtenerJuegoById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<JuegoResponseDto> agregarJuego(@RequestBody @Valid JuegoRequestDto juegoRequestDto){
        return new ResponseEntity<>(service.agregarJuego(juegoRequestDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<JuegoResponseDto> editarJuego(@RequestBody @Valid JuegoConIdRequestDto juegoConIdRequestDto){
        return new ResponseEntity<>(service.editarJuego(juegoConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeResponseDto> eliminarJuego(@PathVariable long id){
        return new ResponseEntity<>(service.eliminarJuego(id), HttpStatus.OK);
    }


}
