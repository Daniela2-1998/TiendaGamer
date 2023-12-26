package com.Tienda.gamer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {

    // VARIABLES / Campos importantes llevan @JoinColumn

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;

    private String apellido;

    private String mail;

    private String dni;

    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    //@JoinColumn(name = "compras_id", nullable = true)
    private List<Compra> compras;


}
