package com.example.civa.service;

import com.example.civa.dto.BusDTO;
import com.example.civa.entity.Bus;
import com.example.civa.mapper.BusMapper;
import com.example.civa.repository.BusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {


    private final BusRepository busRepository;
    public BusService(BusRepository busRepository){ this.busRepository = busRepository; }

    public Page<BusDTO> listAll(Pageable pageable) {
        return busRepository.findAll(pageable).map(BusMapper::toDTO);
    }

    public Optional<BusDTO> findById(Long id) {
        return busRepository.findById(id).map(BusMapper::toDTO);
    }





}
