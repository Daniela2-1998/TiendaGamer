package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.JuegoConIdRequestDto;
import com.Tienda.gamer.dto.request.JuegoRequestDto;
import com.Tienda.gamer.dto.response.JuegoResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;

import java.util.List;

public interface IJuegoService {

    List<JuegoResponseDto> obtenerJuegos();

    JuegoResponseDto obtenerJuegoById(long id);

    JuegoResponseDto agregarJuego(JuegoRequestDto juegoRequestDto);

    JuegoResponseDto editarJuego(JuegoConIdRequestDto juegoConIdRequestDto);

    MensajeResponseDto eliminarJuego(long id);

}
