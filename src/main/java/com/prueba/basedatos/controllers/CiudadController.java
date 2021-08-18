package com.prueba.basedatos.controllers;

import com.prueba.basedatos.dtos.CiudadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.basedatos.responses.CiudadResponse;
import com.prueba.basedatos.services.CiudadService;


@RestController
public class CiudadController {

  @Autowired
  private CiudadService ciudadService;

  @GetMapping("/ciudad")
  public ResponseEntity<CiudadResponse> getCiudad() {
     return ciudadService.getCiudad();
  }

  @PostMapping("/ciudad")
  public ResponseEntity<CiudadResponse> addCiudad(@RequestBody CiudadDto ciudadDto) {
     return ciudadService.createEditCiudad(ciudadDto);
  }

  @PutMapping("/ciudad")
  public ResponseEntity<CiudadResponse> editCiudad(@RequestBody CiudadDto ciudadDto) {
     return ciudadService.createEditCiudad(ciudadDto);
  }

  @DeleteMapping("/ciudad/{id}")
  public ResponseEntity<CiudadResponse> delCiudad(@PathVariable(value = "id") Integer idCiudad) {
     return ciudadService.removeCiudad(idCiudad);
  }

}
