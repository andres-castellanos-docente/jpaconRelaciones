package com.prueba.basedatos.repositories;

import com.prueba.basedatos.entities.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity,Integer> {

}
