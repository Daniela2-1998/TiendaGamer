package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.GeneroConIdRequestDto;
import com.Tienda.gamer.dto.request.GeneroRequestDto;
import com.Tienda.gamer.dto.response.GeneroResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;

import java.util.List;

public interface IGeneroService {

    //   --------------------------------        CRUD        ----------------------------------------------------------
    List<GeneroResponseDto> obtenerGeneros();

    GeneroResponseDto obtenerGeneroById(long id);

    GeneroResponseDto agregarGenero(GeneroRequestDto generoRequestDto);

    GeneroResponseDto editarGenero(GeneroConIdRequestDto generoConIdRequestDto);

    MensajeResponseDto eliminarGenero (long id);


}
