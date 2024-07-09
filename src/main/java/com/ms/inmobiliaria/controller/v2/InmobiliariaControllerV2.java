package com.ms.inmobiliaria.controller.v2;

import com.ms.inmobiliaria.controller.v2.doc.InmobiliariaDocV2;
import com.ms.inmobiliaria.dto.InmobiliariaDto;
import com.ms.inmobiliaria.model.InmobiliariaEntity;
import com.ms.inmobiliaria.service.IInmobiliariaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class InmobiliariaControllerV2 implements InmobiliariaDocV2 {
    private final IInmobiliariaService inmobiliariaService;

    @Override
    public ResponseEntity<InmobiliariaEntity> create(InmobiliariaDto inmobiliariaDto) {
        return this.inmobiliariaService.save(inmobiliariaDto);
    }

    @Override
    public ResponseEntity<InmobiliariaEntity> findByReference(String reference) {
        return this.inmobiliariaService.getByReference(reference);
    }

    @Override
    public ResponseEntity<List<InmobiliariaEntity>> findAll() {
        return this.inmobiliariaService.getAll();
    }

    @Override
    public ResponseEntity<?> delete(String reference) {
        return this.inmobiliariaService.delete(reference);
    }

    @Override
    public ResponseEntity<?> update(InmobiliariaDto inmobiliariaDto) {
        return this.inmobiliariaService.update(inmobiliariaDto);
    }
}
