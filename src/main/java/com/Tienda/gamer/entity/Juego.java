package com.Tienda.gamer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJuego;

    private String titulo;

    @OneToOne
    @JoinColumn(name = "plataforma_id", nullable = false)
    private Plataforma plataforma;

    private LocalDate lanzamiento;

    private Double stock;

    private Double precio;

    //@ManyToMany(mappedBy = "juego")
    //private List<Compra> compras;


}
