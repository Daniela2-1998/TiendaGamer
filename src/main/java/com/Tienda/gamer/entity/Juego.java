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
@Table(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJuego;

    private String titulo;

    @OneToMany(mappedBy = "juego", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Plataforma> plataformas;

    private LocalDate lanzamiento;

    private Double stock;

}
