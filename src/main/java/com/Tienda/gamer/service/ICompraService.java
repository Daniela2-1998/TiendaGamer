package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.CompraConIdRequestDto;
import com.Tienda.gamer.dto.request.CompraRequestDto;
import com.Tienda.gamer.dto.response.CompraResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;

import java.util.List;

public interface ICompraService {

    //   --------------------------------        CRUD        ----------------------------------------------------------

    List<CompraResponseDto> obtenerCompras();

    CompraResponseDto obtenerCompraById(long id);

    CompraResponseDto agregarCompra(CompraRequestDto compraRequestDto);

    CompraResponseDto editarCompra(CompraConIdRequestDto compraConIdRequestDto);

    MensajeResponseDto eliminarCompra(long id);



}
