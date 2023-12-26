package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.CompraConIdRequestDto;
import com.Tienda.gamer.dto.request.CompraRequestDto;
import com.Tienda.gamer.dto.response.CompraResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.entity.Compra;
import com.Tienda.gamer.exception.EntityNotFoundException;
import com.Tienda.gamer.exception.InsertionDBException;
import com.Tienda.gamer.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImp implements ICompraService{


    ICompraRepository compraRepository;

    ModelMapper mapper;

    // ------------------------------------------    CONSTRUCTOR    -------------------------------------------

    public CompraServiceImp(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
        mapper = new ModelMapper();
    }


    // --------------------------------------------    MÉTODOS    -----------------------------------------------------

    // OBTENER COMPRAS
    @Override
    public List<CompraResponseDto> obtenerCompras() {
        List<Compra> responseEntity = compraRepository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay compras registradas en el sistema.");
        }

        List<CompraResponseDto> response = new ArrayList<>();
        responseEntity.stream().forEach(resp -> response.add(mapper.map(resp, CompraResponseDto.class)));

        return response;
    }

    // OBTENER COMPRA POR ID
    @Override
    public CompraResponseDto obtenerCompraById(long id) {
        Optional<Compra> compra = Optional.ofNullable(compraRepository.findById(id));
        if (compra.isEmpty()){
            throw new EntityNotFoundException("No hay compras registradas con ese ID.");
        }

        return mapper.map(compra, CompraResponseDto.class);
    }

    // AGREGAR COMPRA
    @Override
    public CompraResponseDto agregarCompra(CompraRequestDto compraRequestDto) {
        Compra compra = mapper.map(compraRequestDto, Compra.class);
        Compra compraPersist = compraRepository.save(compra);
        if (compra == null){
            throw new InsertionDBException("Error al guardar la compra en la base de datos.");
        }

        return mapper.map(compraPersist, CompraResponseDto.class);
    }

    // EDITAR COMPRA
    @Override
    public CompraResponseDto editarCompra(CompraConIdRequestDto compraConIdRequestDto) {
        Compra compra;
        obtenerCompraById(compraConIdRequestDto.getIdCompra());
        compra = mapper.map(compraConIdRequestDto, Compra.class);
        Compra compraPersist = compraRepository.save(compra);

        return mapper.map(compraPersist, CompraResponseDto.class);
    }

    @Override
    public MensajeResponseDto eliminarCompra(long id) {
        obtenerCompraById(id);
        compraRepository.deleteById(id);

        return new MensajeResponseDto("Se ha eliminado éxitosamente la compra solicitada.");
    }


}
