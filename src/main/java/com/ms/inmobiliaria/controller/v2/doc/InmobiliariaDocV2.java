package com.ms.inmobiliaria.controller.v2.doc;

import com.ms.inmobiliaria.dto.InmobiliariaDto;
import com.ms.inmobiliaria.model.InmobiliariaEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name= "inmobiliaria", description = "API expuesta para la administracion de inmobiliaria")
@RequestMapping("/api/v2/inmobiliaria")
public interface InmobiliariaDocV2 {

    @Operation(summary = "create inmobliiario")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "inmobiliario created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "endpoint no founded",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )

    @PostMapping("/inmobiliario")
    public ResponseEntity<InmobiliariaEntity> create(@RequestBody @Valid InmobiliariaDto inmobiliariaDto);

    @GetMapping("/reference/{reference}")
    public ResponseEntity<InmobiliariaEntity> findByReference(@PathVariable String reference);

    @GetMapping("/retrieve")
    public ResponseEntity<List<InmobiliariaEntity>> findAll();

    @DeleteMapping("/reference/{reference}")
    public ResponseEntity<?> delete(@PathVariable String reference);

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid InmobiliariaDto inmobiliariaDto);
}
