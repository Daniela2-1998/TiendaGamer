package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Juego;
import com.Tienda.gamer.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IJuegoRepository extends JpaRepository<Juego,Long> {

    Juego findById(long id);

    List<Juego> findByTitulo(String titulo);

    List<Juego> findByTituloAndPlataforma(String titulo, Plataforma plataforma);

    List<Juego> findByLanzamiento(LocalDate date);

    Juego findByStock(double stock);

    Juego findByPrecio(double precio);


}
