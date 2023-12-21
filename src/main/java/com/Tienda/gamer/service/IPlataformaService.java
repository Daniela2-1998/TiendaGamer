package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.PlataformaConIdRequestDto;
import com.Tienda.gamer.dto.request.PlataformaRequestDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.dto.response.PlataformaResponseDto;

import java.util.List;

public interface IPlataformaService {

    //   --------------------------------        CRUD        ----------------------------------------------------------
    List<PlataformaResponseDto> obtenerPlataformas();

    PlataformaResponseDto obtenerPlataformaById(long id);

    PlataformaResponseDto agregarPlataforma(PlataformaRequestDto plataformaRequestDto);

    PlataformaResponseDto editarPlataforma(PlataformaConIdRequestDto plataformaConIdRequestDto);

    MensajeResponseDto eliminarPlataforma(long id);

}
