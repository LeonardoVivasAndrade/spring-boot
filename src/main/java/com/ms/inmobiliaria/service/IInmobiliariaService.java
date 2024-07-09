package com.ms.inmobiliaria.service;

import com.ms.inmobiliaria.dto.InmobiliariaDto;
import com.ms.inmobiliaria.model.InmobiliariaEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IInmobiliariaService {
    ResponseEntity<InmobiliariaEntity> save(InmobiliariaDto inmobiliariaDto);
    ResponseEntity<?> delete(String reference);
    ResponseEntity<List<InmobiliariaEntity>> getAll();
    ResponseEntity<InmobiliariaEntity> getByReference(String reference);
    ResponseEntity<InmobiliariaEntity> update(InmobiliariaDto inmobiliariaDto);

}
