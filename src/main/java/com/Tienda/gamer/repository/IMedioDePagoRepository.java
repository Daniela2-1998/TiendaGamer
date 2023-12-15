package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.MedioDePago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedioDePagoRepository extends JpaRepository<MedioDePago,Long> {

    MedioDePago findByMedioDePago(String medio);

    MedioDePago findByCuotasDisponibles(int cuotasDisponibles);

}
