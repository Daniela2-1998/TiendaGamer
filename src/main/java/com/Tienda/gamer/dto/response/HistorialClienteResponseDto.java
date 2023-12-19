package com.Tienda.gamer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistorialClienteResponseDto {

    ClienteSinCompraResponseDto cliente;

    List<CompraSinClienteResponseDto> compras;

    Short comprasTotales;

}
