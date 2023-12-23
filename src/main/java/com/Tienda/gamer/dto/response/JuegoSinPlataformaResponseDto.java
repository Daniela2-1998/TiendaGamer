package com.Tienda.gamer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoSinPlataformaResponseDto {

    private Long idJuego;

    private String titulo;

    private LocalDate lanzamiento;

    private Double stock;

    private Double precio;

}
