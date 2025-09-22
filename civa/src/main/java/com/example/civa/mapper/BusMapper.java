package com.example.civa.mapper;

import com.example.civa.dto.BusDTO;
import com.example.civa.entity.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusMapper {

    BusDTO toDTO(Bus bus);

}
