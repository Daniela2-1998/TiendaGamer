package com.Tienda.gamer.dto.response;

import com.Tienda.gamer.entity.MedioDePago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraSinJuegoResponseDto {

    private Long idCompra;

    private LocalDate fechaCompra;

    private ClienteSinCompraResponseDto cliente;

    private MedioDePago medioDePago;
}
