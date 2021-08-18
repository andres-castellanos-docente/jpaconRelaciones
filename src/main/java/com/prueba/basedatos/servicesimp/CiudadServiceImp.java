package com.prueba.basedatos.servicesimp;

import java.util.*;

import com.prueba.basedatos.dtos.CiudadDto;
import com.prueba.basedatos.entities.PaisEntity;
import com.prueba.basedatos.repositories.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.basedatos.services.CiudadService;
import org.springframework.http.ResponseEntity;
import com.prueba.basedatos.entities.CiudadEntity;
import com.prueba.basedatos.responses.CiudadResponse;
import com.prueba.basedatos.repositories.CiudadRepository;

@Service
public class CiudadServiceImp implements CiudadService {

@Autowired
private CiudadRepository ciudadRepository;


@Autowired
private PaisRepository paisRepository;

  @Override
  public ResponseEntity<CiudadResponse> getCiudad() {
    List<String> listMess = new ArrayList<>();
    try {
      List<CiudadEntity> ciudadAll = ciudadRepository.findAll();
      listMess.add("Se consulta ok");
      return new ResponseEntity<>(new CiudadResponse(1, listMess, ciudadAll, HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al consultar");
        return new ResponseEntity<>(new CiudadResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<CiudadResponse> createEditCiudad(CiudadDto ciudadDto) {
    List<String> listMess = new ArrayList<>();
    try {
      CiudadEntity ciudadEntity = new CiudadEntity();
      List<CiudadEntity> listCiudadSaved = new ArrayList<>();
      if (Objects.isNull(ciudadDto.getId())==false){
        ciudadEntity.setId(ciudadDto.getId());
      }
      ciudadEntity.setNombre(ciudadDto.getNombre());
      Optional<PaisEntity> pais = paisRepository.findById(ciudadDto.getIdPai());
      ciudadEntity.setPaisByIdPais(pais.get());
      CiudadEntity ciudadSaved = ciudadRepository.save(ciudadEntity);
      listCiudadSaved.add(ciudadSaved);
      listMess.add("Se guardó ok");
      return new ResponseEntity<>(new CiudadResponse(1, listMess,listCiudadSaved,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al guardar");
        return new ResponseEntity<>(new CiudadResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<CiudadResponse> removeCiudad(Integer idCiudad) {
    List<String> listMess = new ArrayList<>();
    try {
      ciudadRepository.deleteById(idCiudad);
      listMess.add("Se elimina ok");
      return new ResponseEntity<>(new CiudadResponse(1, listMess,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al eliminar");
        return new ResponseEntity<>(new CiudadResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
