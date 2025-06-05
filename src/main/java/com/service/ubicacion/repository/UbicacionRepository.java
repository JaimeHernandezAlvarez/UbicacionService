package com.service.ubicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ubicacion.model.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion,Long>{

}
