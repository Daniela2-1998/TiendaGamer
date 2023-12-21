package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.PlataformaConIdRequestDto;
import com.Tienda.gamer.dto.request.PlataformaRequestDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.dto.response.PlataformaResponseDto;
import com.Tienda.gamer.entity.Plataforma;
import com.Tienda.gamer.exception.EntityAlreadyExistException;
import com.Tienda.gamer.exception.EntityNotFoundException;
import com.Tienda.gamer.exception.InsertionDBException;
import com.Tienda.gamer.repository.IPlataformaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlataformaServiceImp implements IPlataformaService{

    IPlataformaRepository plataformaRepository;

    ModelMapper mapper;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------

    public PlataformaServiceImp(IPlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
        mapper = new ModelMapper();
    }

    // --------------------------------------------    MÉTODOS    -----------------------------------------------------

    // OBTENER PLATAFORMAS
    @Override
    public List<PlataformaResponseDto> obtenerPlataformas() {
        List<Plataforma> responseEntity = plataformaRepository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay plataformas registradas en el sistema.");
        }
        List<PlataformaResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(resp -> response.add(mapper.map(resp, PlataformaResponseDto.class)));
        return response;
    }

    // OBTENER PLATAFORMA POR ID
    @Override
    public PlataformaResponseDto obtenerPlataformaById(long id) {
        Optional<Plataforma> plataforma = Optional.ofNullable(plataformaRepository.findById(id));
        if (plataforma.isEmpty()){
            throw new EntityNotFoundException("No hay plataformas registrados con ese ID.");
        }

        return mapper.map(plataforma, PlataformaResponseDto.class);
    }

    // AGREGAR PLATAFORMA
    @Override
    public PlataformaResponseDto agregarPlataforma(PlataformaRequestDto plataformaRequestDto) {
        if(plataformaRepository.findByNombre(plataformaRequestDto.getNombre()) != null){
            throw new EntityAlreadyExistException("Ya hay una plataforma con ese nombre.");
        }
        Plataforma plataforma = mapper.map(plataformaRequestDto, Plataforma.class);
        Plataforma plataformaPersist = plataformaRepository.save(plataforma);

        if(plataforma == null){
            throw new InsertionDBException("Error al guardar la plataforma en la base de datos.");
        }

        return mapper.map(plataformaPersist, PlataformaResponseDto.class);
    }

    // MODIFICAR PLATAFORMA
    @Override
    public PlataformaResponseDto editarPlataforma(PlataformaConIdRequestDto plataformaConIdRequestDto) {
       Plataforma plataforma = plataformaRepository.findByNombre(plataformaConIdRequestDto.getNombre());
        if (plataforma != null && plataforma.getNombre() != plataformaConIdRequestDto.getNombre()){
            throw new EntityAlreadyExistException("Ya hay una plataforma con ese nombre.");
        }

        obtenerPlataformaById(plataformaConIdRequestDto.getIdPlataforma());
        plataforma = mapper.map(plataformaConIdRequestDto, Plataforma.class);
        Plataforma plataformaPersist = plataformaRepository.save(plataforma);

        return mapper.map(plataformaPersist, PlataformaResponseDto.class);
    }

    // ELIMINAR PLATAFORMA
    @Override
    public MensajeResponseDto eliminarPlataforma(long id) {
        obtenerPlataformaById(id);
        plataformaRepository.deleteById(id);
        return new MensajeResponseDto("Se eliminó la plataforma solicitada.");
    }
}
