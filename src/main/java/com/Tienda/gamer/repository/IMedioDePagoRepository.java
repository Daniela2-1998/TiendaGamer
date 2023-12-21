package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.MedioDePago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMedioDePagoRepository extends JpaRepository<MedioDePago,Long> {

    MedioDePago findById(long id);

    MedioDePago findByMedio(String medio);

    MedioDePago findByCuotasDisponibles(int cuotasDisponibles);

}
