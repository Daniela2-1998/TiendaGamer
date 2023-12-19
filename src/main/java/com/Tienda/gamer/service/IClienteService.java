package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.ClienteConIdRequestDto;
import com.Tienda.gamer.dto.request.ClienteRequestDto;
import com.Tienda.gamer.dto.response.ClienteResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;

import java.util.List;

public interface IClienteService {

    //   --------------------------------        CRUD        -----------------------------------------------------------

    List<ClienteResponseDto> obtenerClientes();

    ClienteResponseDto obtenerClienteById(long id);

    ClienteResponseDto agregarCliente (ClienteRequestDto clienteRequestDto);

    ClienteResponseDto editarCliente (ClienteConIdRequestDto clienteConIdRequestDto);

    MensajeResponseDto eliminarCliente (long id);




// EXTRAS ---------------------------------------------------------------------------

    /*
    ClienteResponseDto obtenerClienteByNombreAndApellido(String nombre, String apellido);

    ClienteResponseDto obtenerClienteByDni(String dni);

    List<ClienteResponseDto> obtenerClientesByFechaRegistro(LocalDate date);

 */
}
