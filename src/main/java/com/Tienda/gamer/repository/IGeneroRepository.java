package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneroRepository extends JpaRepository<Genero,Long> {

    Genero findById(long id);

    Genero findByNombre(String nombre);

}
