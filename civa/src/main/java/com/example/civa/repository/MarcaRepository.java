package com.example.civa.repository;


import com.example.civa.entity.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio para la entidad {Marcas}.
 * Permite realizar operaciones CRUD y consultas personalizadas.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */
public interface MarcaRepository extends JpaRepository<Marcas, Long> {

    Optional<Marcas> findByName(String name);

}
