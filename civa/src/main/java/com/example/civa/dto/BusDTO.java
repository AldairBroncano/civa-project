package com.example.civa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

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
