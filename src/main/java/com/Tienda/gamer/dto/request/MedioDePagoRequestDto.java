package com.Tienda.gamer.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedioDePagoRequestDto {

    @NotNull(message = "El nombre del medio de pago no puede ser nulo.")
    @NotEmpty(message = "El nombre del medio de pago no puede estar vacío.")
    private String medio;

    @Min(value = 1, message = "El mínimo es en 1 pago.")
    @Max(value = 18, message = "El máximo es 18 cuotas.")
    private Integer cuotasDisponibles;

}
