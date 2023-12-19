package com.Tienda.gamer.dto.request;

import com.Tienda.gamer.entity.Compra;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDto {

    @NotNull(message = "El campo nombre no puede ser nulo.")
    @NotEmpty(message = "El campo nombre no puede quedar vacío.")
    @Size(min = 2, max = 24, message = "El nombre debe contener entre 2 y 24 caracteres.")
    private String nombre;

    @NotNull(message = "El campo apellido no puede ser nulo.")
    @NotEmpty(message = "El campo apellido no puede quedar vacío.")
    @Size(min = 2, max = 24, message = "El apellido debe contener entre 2 y 24 caracteres.")
    private String apellido;

    @NotNull(message = "El campo mail no puede ser nulo.")
    @NotEmpty(message = "El campo mail no puede estar vacío.")
    @Email(message = "Ingresa un mail válido.")
    private String mail;

    @NotNull(message = "El campo DNI no puede ser nulo.")
    @NotEmpty(message = "El campo DNI no puede estar vacío.")
    @Min(value = 10000000, message = "Debes ingresar un valor superior a 10000000.")
    @Max(value = 60000000, message = "Debes ingresar un valor inferior a 60000000.")
    private String dni;

    @PastOrPresent(message = "La fecha no debe ser posterior a la fecha actual.")
    private LocalDate fechaRegistro;

    private List<Compra> compras;

}
