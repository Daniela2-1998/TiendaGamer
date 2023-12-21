package com.Tienda.gamer.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlataformaConIdRequestDto {

    @NotNull(message = "El id no puede ser nulo.")
    private Long idPlataforma;

    @NotNull(message = "El nombre de la plataforma no puede ser nulo.")
    @NotEmpty(message = "El nombre de la plataforma no puede estar vacío.")
    private String nombre;

}
