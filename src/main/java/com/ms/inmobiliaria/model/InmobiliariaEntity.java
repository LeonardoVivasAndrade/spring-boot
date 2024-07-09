package com.ms.inmobiliaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inmobiliaria")
public class InmobiliariaEntity {
    @Id
    private String id;
    private String reference;
    private String descripcion;
    private String location;
    private int dimension;
    private String type;
    private String status;
    private String owner;
    private String dateBuilding;
    private String project;
    private double price;
}
