package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.JuegoConIdRequestDto;
import com.Tienda.gamer.dto.request.JuegoRequestDto;
import com.Tienda.gamer.dto.response.JuegoResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.entity.Juego;
import com.Tienda.gamer.exception.EntityAlreadyExistException;
import com.Tienda.gamer.exception.EntityNotFoundException;
import com.Tienda.gamer.exception.InsertionDBException;
import com.Tienda.gamer.repository.IJuegoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JuegoServiceImp implements IJuegoService{


    IJuegoRepository juegoRepository;

    ModelMapper mapper;


    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public JuegoServiceImp(IJuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
        mapper = new ModelMapper();
    }

    // --------------------------------------------    MÉTODOS    -----------------------------------------------------

    // OBTENER JUEGO
    @Override
    public List<JuegoResponseDto> obtenerJuegos() {
        List<Juego> responseEntity = juegoRepository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay juegos registrados en el sistema.");
        }

        List<JuegoResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(resp -> response.add(mapper.map(resp, JuegoResponseDto.class)));
        return response;
    }

    // OBTENER JUEGO POR ID
    @Override
    public JuegoResponseDto obtenerJuegoById(long id) {
        Optional<Juego> juego = Optional.ofNullable(juegoRepository.findById(id));
        if(juego.isEmpty()){
            throw new EntityNotFoundException("No hay juegos registrados con ese ID.");
        }

        return mapper.map(juego, JuegoResponseDto.class);
    }

    // AGREGAR JUEGO
    @Override
    public JuegoResponseDto agregarJuego(JuegoRequestDto juegoRequestDto) {
        Juego juego = mapper.map(juegoRequestDto, Juego.class);
        Juego juegoPersist = juegoRepository.save(juego);

        if (juego == null){
            throw new InsertionDBException("Error al guardar el juego en la base de datos.");
        }

        return mapper.map(juegoPersist, JuegoResponseDto.class);
    }

    @Override
    public JuegoResponseDto editarJuego(JuegoConIdRequestDto juegoConIdRequestDto) {
        Juego juego = juegoRepository.findByTitulo(juegoConIdRequestDto.getTitulo());
        if (juego != null && juego.getIdJuego() != juegoConIdRequestDto.getIdJuego()){
            throw new EntityAlreadyExistException("Ya hay otro juego registrado con ese DNI.");
        }

        obtenerJuegoById(juegoConIdRequestDto.getIdJuego());
        juego = mapper.map(juegoConIdRequestDto, Juego.class);
        Juego juegoPersist = juegoRepository.save(juego);

        return mapper.map(juegoPersist, JuegoResponseDto.class);
    }

    @Override
    public MensajeResponseDto eliminarJuego(long id) {
        obtenerJuegoById(id);
        juegoRepository.deleteById(id);

        return new MensajeResponseDto("Se eliminó correctamente al videojuego solicitado.");
    }

}
