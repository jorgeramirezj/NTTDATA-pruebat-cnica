package com.jorgeramirez.pruebatecnica.infrastructure.controller.mapper;

import org.mapstruct.Mapper;

import com.jorgeramirez.pruebatecnica.domain.model.Usuario;
import com.jorgeramirez.pruebatecnica.infrastructure.config.MapStructConfig;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.response.UsuarioResponse;

@Mapper(config = MapStructConfig.class)
public interface UsuarioControllerMapper {

  UsuarioResponse toResponse(Usuario usuario);

}
