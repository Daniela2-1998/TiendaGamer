package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.GeneroConIdRequestDto;
import com.Tienda.gamer.dto.request.GeneroRequestDto;
import com.Tienda.gamer.dto.response.GeneroResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.entity.Genero;
import com.Tienda.gamer.exception.EntityAlreadyExistException;
import com.Tienda.gamer.exception.EntityNotFoundException;
import com.Tienda.gamer.exception.InsertionDBException;
import com.Tienda.gamer.repository.IGeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImp implements IGeneroService{

    IGeneroRepository generoRepository;

    ModelMapper mapper;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public GeneroServiceImp(IGeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
        mapper = new ModelMapper();
    }

    // --------------------------------------------    MÉTODOS    -----------------------------------------------------

    // OBTENER GENERO
    @Override
    public List<GeneroResponseDto> obtenerGeneros() {
        List<Genero> responseEntity = generoRepository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay géneros registrados en el sistema.");
        }

        List<GeneroResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(resp -> response.add(mapper.map(resp, GeneroResponseDto.class)));

        return response;
    }

    // OBTENER GENERO POR ID
    @Override
    public GeneroResponseDto obtenerGeneroById(long id) {
        Optional<Genero> genero = Optional.ofNullable(generoRepository.findById(id));
        if (genero.isEmpty()){
            throw new EntityNotFoundException("No hay géneros registrados con ese ID.");
        }

        return mapper.map(genero, GeneroResponseDto.class);
    }

    // AGREGAR GENERO
    @Override
    public GeneroResponseDto agregarGenero(GeneroRequestDto generoRequestDto) {
        if(generoRepository.findByNombre(generoRequestDto.getNombre()) != null){
            throw new EntityAlreadyExistException("Ya hay un género con ese nombre.");
        }

        Genero genero = mapper.map(generoRequestDto, Genero.class);
        Genero generoPersist = generoRepository.save(genero);

        if(genero == null){
            throw new InsertionDBException("Error al guardar el género en la base de datos.");
        }

        return mapper.map(generoPersist, GeneroResponseDto.class);
    }

    // MODIFICAR GENERO
    @Override
    public GeneroResponseDto editarGenero(GeneroConIdRequestDto generoConIdRequestDto) {
        Genero genero = generoRepository.findByNombre(generoConIdRequestDto.getNombre());
        if(genero != null && genero.getNombre() != generoConIdRequestDto.getNombre()){
            throw new EntityAlreadyExistException("Ya hay otro género registrado con ese nombre.");
        }

        obtenerGeneroById(generoConIdRequestDto.getId());
        genero = mapper.map(generoConIdRequestDto, Genero.class);

        Genero generoPersist = generoRepository.save(genero);

        return mapper.map(generoPersist, GeneroResponseDto.class);
    }

    // ELIMINAR GENERO
    @Override
    public MensajeResponseDto eliminarGenero(long id) {
        obtenerGeneroById(id);
        generoRepository.deleteById(id);

        return new MensajeResponseDto("El género solicitado se ha eliminado correctamente.");
    }
}
