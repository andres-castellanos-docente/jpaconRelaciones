package com.prueba.basedatos.services;

import com.prueba.basedatos.dtos.CiudadDto;
import org.springframework.http.ResponseEntity;
import com.prueba.basedatos.entities.CiudadEntity;
import com.prueba.basedatos.responses.CiudadResponse;

public interface CiudadService {

  ResponseEntity<CiudadResponse> getCiudad();
  ResponseEntity<CiudadResponse> createEditCiudad(CiudadDto ciudadDto);
  ResponseEntity<CiudadResponse> removeCiudad(Integer idCiudad);

}
