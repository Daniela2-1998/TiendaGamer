package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.MedioDePagoConIdRequestDto;
import com.Tienda.gamer.dto.request.MedioDePagoRequestDto;
import com.Tienda.gamer.dto.response.MedioDePagoResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;

import java.util.List;

public interface IMedioDePagoService {

    //   --------------------------------        CRUD        -----------------------------------------------------------
    List<MedioDePagoResponseDto> obtenerMediosDePago();

    MedioDePagoResponseDto obtenerMedioDePagoById(long id);

    MedioDePagoResponseDto agregarMedioDePago(MedioDePagoRequestDto medioDePagoRequestDto);

    MedioDePagoResponseDto editarMedioDePago(MedioDePagoConIdRequestDto medioDePagoConIdRequestDto);

    MensajeResponseDto eliminarMedioDePago(long id);

}
