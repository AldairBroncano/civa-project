package com.example.civa.controller;

import com.example.civa.dto.BusDTO;
import com.example.civa.service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de buses.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/buses")
@Tag(name = "Bus Controller", description = "API para gestión de buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService){
        this.busService = busService;
    }

    /**
     * Obtiene todos los buses con paginación.
     *
     * @param page número de página (0-based, default = 0)
     * @param size cantidad de registros por página (default = 10)
     * @return lista paginada de buses
     */
    @GetMapping
    @Operation(summary = "Listar todos los buses",
            description = "Obtiene una lista paginada de todos los buses disponibles")
    public ResponseEntity<?> getAll(
            @Parameter(description = "Número de página (0-based)", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Cantidad de registros por página", example = "10")
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        Page<BusDTO> dtoPage = busService.getAll(pageable);
        return ResponseEntity.ok(dtoPage);
    }

    /**
     * Obtiene un bus por su ID.
     *
     * @param id ID del bus
     * @return BusDTO si se encuentra, 404 si no existe
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener bus por ID",
            description = "Devuelve los detalles de un bus dado su ID")
    public ResponseEntity<BusDTO> getById(
            @Parameter(description = "ID del bus", required = true, example = "1")
            @PathVariable Long id
    ){
        return busService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
