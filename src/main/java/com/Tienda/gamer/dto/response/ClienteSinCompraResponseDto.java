package com.Tienda.gamer.dto.response;

import com.Tienda.gamer.entity.Compra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSinCompraResponseDto {

    private Long idCliente;

    private String nombre;

    private String apellido;

    private String mail;

    private String dni;

    private LocalDate fechaRegistro;

}
