package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlataformaRepository extends JpaRepository<Plataforma,Long> {

    List<Plataforma> findByNombre(String nombre);

}