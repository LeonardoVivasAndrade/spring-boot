package com.ms.inmobiliaria.repository;

import com.ms.inmobiliaria.model.InmobiliariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IInmobiliariaRepository extends JpaRepository<InmobiliariaEntity,String> {
    Optional<InmobiliariaEntity> findByReference(String reference);
}
