package com.example.civa.mapper;

import com.example.civa.dto.BusDTO;
import com.example.civa.entity.Bus;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entidades {Bus} a objetos { BusDTO}.
 * Utiliza MapStruct con integración en Spring.
 *
 * @author Aldair Broncano
 * @version 1.0.0
 */
@Mapper(componentModel = "spring")
public interface BusMapper {

    BusDTO toDTO(Bus bus);

}
