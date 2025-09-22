package com.example.civa.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una marca de buses en el sistema.
 * Se persiste en la tabla "marcas".
 *
 * Cada marca tiene un identificador único y un nombre único.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "marcas")
public class Marcas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;



}
