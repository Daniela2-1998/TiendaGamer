package com.Tienda.gamer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedioDePagoResponseDto {

    private Long idMedioDePago;

    private String medio;

    private int cuotasDisponibles;

}
