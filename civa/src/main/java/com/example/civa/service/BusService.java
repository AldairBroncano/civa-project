package com.example.civa.service;

import com.example.civa.dto.BusDTO;
import com.example.civa.mapper.BusMapper;
import com.example.civa.repository.BusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la gestión de buses.
 * Proporciona métodos para obtener buses de la base de datos y convertirlos a DTOs.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 *
 */
@Service
public class BusService {

    private final BusMapper busMapper;
    private final BusRepository busRepository;

    public BusService(BusMapper busMapper, BusRepository busRepository){
        this.busMapper = busMapper;
        this.busRepository = busRepository;
    }

    /**
     * Obtiene todos los buses con paginación.
     *
     * @param pageable información de paginación
     * @return página de objetos BusDTO
     */
    public Page<BusDTO> getAll(Pageable pageable) {
        return busRepository
                .findAll(pageable)
                .map(busMapper::toDTO);
    }

    /**
     * Busca un bus por su ID.
     *
     * @param id ID del bus
     * @return Optional con BusDTO si se encuentra, vacío si no existe
     */
    public Optional<BusDTO> findById(Long id) {
        return busRepository
                .findById(id)
                .map(busMapper::toDTO);
    }

}
