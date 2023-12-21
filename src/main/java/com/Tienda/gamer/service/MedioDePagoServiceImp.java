package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.MedioDePagoConIdRequestDto;
import com.Tienda.gamer.dto.request.MedioDePagoRequestDto;
import com.Tienda.gamer.dto.response.MedioDePagoResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.entity.MedioDePago;
import com.Tienda.gamer.exception.EntityAlreadyExistException;
import com.Tienda.gamer.exception.EntityNotFoundException;
import com.Tienda.gamer.exception.InsertionDBException;
import com.Tienda.gamer.repository.IMedioDePagoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedioDePagoServiceImp implements IMedioDePagoService{

    IMedioDePagoRepository medioDePagoRepository;

    ModelMapper mapper;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public MedioDePagoServiceImp(IMedioDePagoRepository medioDePagoRepository) {
        this.medioDePagoRepository = medioDePagoRepository;
        mapper = new ModelMapper();
    }

    // --------------------------------------------    MÉTODOS    -----------------------------------------------------

    // OBTENER CLIENTES
    @Override
    public List<MedioDePagoResponseDto> obtenerMediosDePago() {
        List<MedioDePago> responseEntity = medioDePagoRepository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay medios de pago registrados.");
        }

        List<MedioDePagoResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(resp -> response.add(mapper.map(resp, MedioDePagoResponseDto.class)));
        return response;
    }

    // OBTENER MEDIO DE PAGO POR ID
    @Override
    public MedioDePagoResponseDto obtenerMedioDePagoById(long id) {
        Optional<MedioDePago> medioDePago = Optional.ofNullable(medioDePagoRepository.findById(id));
        if(medioDePago.isEmpty()){
            throw new EntityNotFoundException("No hay medios de pago con ese ID.");
        }

        return mapper.map(medioDePago, MedioDePagoResponseDto.class);
    }

    // AGREGAR MEDIO DE PAGO
    @Override
    public MedioDePagoResponseDto agregarMedioDePago(MedioDePagoRequestDto medioDePagoRequestDto) {
        MedioDePago medioDePago = mapper.map(medioDePagoRequestDto, MedioDePago.class);
        MedioDePago medioDePagoPersist = medioDePagoRepository.save(medioDePago);

        if(medioDePago == null){
            throw new InsertionDBException("Error al guardar el medio de pago en la base de datos.");
        }

        return mapper.map(medioDePagoPersist, MedioDePagoResponseDto.class);
    }

    // MODIFICAR MEDIO DE PAGO
    @Override
    public MedioDePagoResponseDto editarMedioDePago(MedioDePagoConIdRequestDto medioDePagoConIdRequestDto) {
        MedioDePago medioDePago = medioDePagoRepository.findByMedio(medioDePagoConIdRequestDto.getMedio());
        if(medioDePago != null && medioDePago.getIdMedioDePago() != medioDePagoConIdRequestDto.getIdMedioDePago()){
            throw new EntityAlreadyExistException("Ya hay un medio de pago con ese ID.");
        }

        medioDePago = medioDePagoRepository.findByMedio(medioDePagoConIdRequestDto.getMedio());
        if (medioDePago != null && medioDePago.getMedio() != medioDePagoConIdRequestDto.getMedio()){
            throw new EntityAlreadyExistException("Ya hay un medio de pago con ese nombre.");
        }

        obtenerMedioDePagoById(medioDePagoConIdRequestDto.getIdMedioDePago());
        medioDePago = mapper.map(medioDePagoConIdRequestDto, MedioDePago.class);
        MedioDePago medioDePagoPersist = medioDePagoRepository.save(medioDePago);

        return mapper.map(medioDePagoPersist, MedioDePagoResponseDto.class);
    }

    // ELIMINAR MEDIO DE PAGO
    @Override
    public MensajeResponseDto eliminarMedioDePago(long id) {
        obtenerMedioDePagoById(id);
        medioDePagoRepository.deleteById(id);

        return new MensajeResponseDto("Se eliminó el medio solicitado de manera éxitosa.");
    }

}
