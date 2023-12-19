package com.Tienda.gamer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraSinClienteResponseDto {

    // Clase Dto Compra sin incluir cliente

    private Long idCompra;

    private LocalDate fechaCompra;

    // OBSERVAR ESTAS CLASES NUEVAS
    private List<JuegoResponseDto> juegos;

    private ClienteSinCompraResponseDto cliente;

    private MedioDePagoResponseDto medioDePago;
}
