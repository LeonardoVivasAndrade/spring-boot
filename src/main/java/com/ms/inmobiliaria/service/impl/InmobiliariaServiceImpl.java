package com.ms.inmobiliaria.service.impl;

import com.ms.inmobiliaria.dto.InmobiliariaDto;
import com.ms.inmobiliaria.exception.MyHandleException;
import com.ms.inmobiliaria.model.InmobiliariaEntity;
import com.ms.inmobiliaria.repository.IInmobiliariaRepository;
import com.ms.inmobiliaria.service.IInmobiliariaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InmobiliariaServiceImpl implements IInmobiliariaService {

    private final IInmobiliariaRepository inmobiliariaRepository;

    @Override
    public ResponseEntity<InmobiliariaEntity> save(InmobiliariaDto inmobiliariaDto) {
        String uuid = UUID.randomUUID().toString();
        InmobiliariaEntity inmobiliaria = InmobiliariaEntity
                .builder()
                .id(uuid)
                .descripcion(inmobiliariaDto.getDescripcion())
                .location(inmobiliariaDto.getLocation())
                .owner(inmobiliariaDto.getOwner())
                .price(inmobiliariaDto.getPrice())
                .type(inmobiliariaDto.getType())
                .dateBuilding(inmobiliariaDto.getDateBuilding())
                .dimension(inmobiliariaDto.getDimension())
                .reference(inmobiliariaDto.getReference())
                .status(inmobiliariaDto.getStatus())
                .project(inmobiliariaDto.getProject())
                .build();

        var newInmobiliaria = this.inmobiliariaRepository.save(inmobiliaria);
        return ResponseEntity.ok(newInmobiliaria);
    }

    @Override
    public ResponseEntity<?> delete(String reference) {
        var inmobiliariaOpt = this.inmobiliariaRepository.findByReference(reference);
        if(inmobiliariaOpt.isPresent()){
            this.inmobiliariaRepository.deleteById(inmobiliariaOpt.get().getId());
            return ResponseEntity.ok("deleted ok");
        }
        throw new MyHandleException("no se encontró inmobiliario por la referencia " + reference);
    }

    @Override
    public ResponseEntity<List<InmobiliariaEntity>> getAll() {
        var list = this.inmobiliariaRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<InmobiliariaEntity> getByReference(String reference) {
        var inmobiliariaOpt = this.inmobiliariaRepository.findByReference(reference);
        if(inmobiliariaOpt.isPresent()){
            return ResponseEntity.ok(inmobiliariaOpt.get());
        }
        throw new MyHandleException("no se encontró inmobiliario por la referencia " + reference);
    }

    @Override
    public ResponseEntity<InmobiliariaEntity> update(InmobiliariaDto inmobiliariaDto) {
        var inmobiliariaOpt = this.inmobiliariaRepository.findByReference(inmobiliariaDto.getReference());

        if(inmobiliariaOpt.isPresent()){
            InmobiliariaEntity iModified = inmobiliariaOpt.get();
            iModified.setDescripcion(inmobiliariaDto.getDescripcion());
            iModified.setReference(inmobiliariaDto.getReference());
            iModified.setLocation(inmobiliariaDto.getLocation());
            iModified.setOwner(inmobiliariaDto.getOwner());
            iModified.setPrice(inmobiliariaDto.getPrice());
            iModified.setType(inmobiliariaDto.getType());
            iModified.setDateBuilding(inmobiliariaDto.getDateBuilding());
            iModified.setDimension(inmobiliariaDto.getDimension());
            iModified.setStatus(inmobiliariaDto.getStatus());
            iModified.setProject(inmobiliariaDto.getProject());
            this.inmobiliariaRepository.save(iModified);
            return ResponseEntity.ok(iModified);
        }

        throw new MyHandleException("no se encontró inmobiliario por la referencia " + inmobiliariaDto.getReference());
    }
}
