package com.Tienda.gamer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {

    private Long idCliente;

    private String nombre;

    private String apellido;

    private String mail;

    private String dni;

    private LocalDate fechaRegistro;

    private List<CompraSinClienteResponseDto> compras;


}
