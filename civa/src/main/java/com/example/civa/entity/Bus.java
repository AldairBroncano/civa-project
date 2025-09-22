package com.example.civa.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entidad que representa un bus en el sistema.
 * Contiene información sobre número, placa, características,
 * marca, estado y fecha de creación.
 *
 * Se persiste en la tabla "buses".
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */

@Data
@Entity
@Table(name = "buses")
public class Bus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String numeroBus;

    @Column(nullable=false, unique=true)
    private String placa;

    @Column(nullable=false)
    private LocalDateTime fechaCreacion;

    @Column(length=1000)
    private String caracteristicas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private Marcas marca;

    @Column(nullable=false)
    private boolean activo = true;

    @PrePersist
    public void prePersist(){
        fechaCreacion = LocalDateTime.now();
    }


}
