package com.example.civa.repository;


import com.example.civa.entity.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marcas, Long> {

    Optional<Marcas> findByName(String name);

}
