package com.ms.inmobiliaria.controller.v1;

import com.ms.inmobiliaria.dto.InmobiliariaDto;
import com.ms.inmobiliaria.model.InmobiliariaEntity;
import com.ms.inmobiliaria.service.IInmobiliariaService;
import jakarta.validation.Valid;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/inmobiliaria")
public class InmobiliariaController {

    private final IInmobiliariaService inmobiliariaService;

    public InmobiliariaController(IInmobiliariaService inmobiliariaService) {
        this.inmobiliariaService = inmobiliariaService;
    }

    @PostMapping
    public ResponseEntity<InmobiliariaEntity> create(@RequestBody @Valid InmobiliariaDto inmobiliariaDto){
        return this.inmobiliariaService.save(inmobiliariaDto);
    }

    @GetMapping("/reference/{reference}")
    public ResponseEntity<InmobiliariaEntity> findByReference(@PathVariable String reference){
        return this.inmobiliariaService.getByReference(reference);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<InmobiliariaEntity>> findAll(){
        return this.inmobiliariaService.getAll();
    }

    @DeleteMapping("/reference/{reference}")
    public ResponseEntity<?> delete(@PathVariable String reference){
        return this.inmobiliariaService.delete(reference);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid InmobiliariaDto inmobiliariaDto){
        return this.inmobiliariaService.update(inmobiliariaDto);
    }
}
