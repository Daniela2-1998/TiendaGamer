package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPlataformaRepository extends JpaRepository<Plataforma,Long> {

    Plataforma findById(long id);

    Plataforma findByNombre(String nombre);

}
