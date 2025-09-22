package com.example.civa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO para representar la información de un bus.
 * Incluye datos básicos como número, placa, características,
 * marca asociada, estado y fecha de creación.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
public class BusDTO {


    private Long id;
    private String numeroBus;
    private String placa;
    private String caracteristicas;
    private MarcaDTO marca;
    private boolean activo;
    private LocalDateTime fechaCreacion;


}
