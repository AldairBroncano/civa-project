package com.example.civa.controller;

import com.example.civa.dto.BusDTO;
import com.example.civa.entity.Bus;
import com.example.civa.mapper.BusMapper;
import com.example.civa.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bus")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService){ this.busService = busService; }

    @GetMapping
    public ResponseEntity<?> getBuses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);


        Page<BusDTO> dtoPage = busService.listAll(pageable);

        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> getBusById(@PathVariable Long id){
        return busService.findById(id)
                .map(busDTO -> ResponseEntity.ok(busDTO))
                .orElse(ResponseEntity.notFound().build());
    }


}
