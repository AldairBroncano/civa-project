package com.example.civa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para representar la información de una marca.
 * Contiene el identificador y el nombre de la marca.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
public class MarcaDTO {

    private Long id;
    private String name;



}
