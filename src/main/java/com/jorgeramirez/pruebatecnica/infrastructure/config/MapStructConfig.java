package com.jorgeramirez.pruebatecnica.infrastructure.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public class MapStructConfig {
}
