package com.example.civa.mapper;

import com.example.civa.dto.BusDTO;
import com.example.civa.dto.MarcaDTO;
import com.example.civa.entity.Bus;
import org.springframework.stereotype.Component;

@Component
public class BusMapper {

    public static BusDTO toDTO(Bus bus) {
        if (bus == null) return null;

        MarcaDTO marcaDTO = null;
        if(bus.getMarca() != null) {
            marcaDTO = new MarcaDTO(bus.getMarca().getId(), bus.getMarca().getName());
        }

        return new BusDTO(
                bus.getId(),
                bus.getNumeroBus(),
                bus.getPlaca(),
                bus.getCaracteristicas(),
                marcaDTO,
                bus.isActivo(),
                bus.getFechaCreacion()
        );
    }


}
