package com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jorgeramirez.pruebatecnica.domain.model.Venta;
import com.jorgeramirez.pruebatecnica.infrastructure.config.MapStructConfig;
import com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa.entity.VentaEntity;

@Mapper(config = MapStructConfig.class)
public interface VentaEntityMapper {

  @Mapping(
      target = "id",
      source = "idVenta"
  )
  @Mapping(
      target = "empleadoId",
      source = "idEmpleado"
  )
  @Mapping(
      target = "descripcion",
      source = "descripcionVenta"
  )
  @Mapping(
      target = "valor",
      source = "valorVenta"
  )
  Venta toDomain(VentaEntity entity);

  @InheritInverseConfiguration
  VentaEntity toEntity(Venta venta);

}
