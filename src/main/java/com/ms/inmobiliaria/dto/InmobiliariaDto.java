package com.ms.inmobiliaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InmobiliariaDto {
    @NotBlank
    @NotEmpty
    private String descripcion;

    @NotBlank
    @NotEmpty
    private String reference;

    @NotBlank
    @NotEmpty
    private String location;

    @Min(value = 0, message = "El valor debe ser mayor a cero")
    @Positive
    private int dimension;
    @NotBlank
    @NotEmpty
    private String type;
    private String status;
    @NotBlank
    @NotEmpty
    private String owner;
    @NotBlank
    @NotEmpty
    private String dateBuilding;
    private String project;
    private double price;
}
