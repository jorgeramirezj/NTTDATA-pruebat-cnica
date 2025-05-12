package com.jorgeramirez.pruebatecnica.infrastructure.persistence.inmemory;

import java.util.List;

import com.jorgeramirez.pruebatecnica.domain.model.TipoDocumento;
import com.jorgeramirez.pruebatecnica.domain.model.Usuario;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DemoUsuarios {

  public static final Usuario USUARIO_DEMO_1 = Usuario.builder()
      .tipoDocumento(TipoDocumento.C)
      .numeroDocumento("23445322")
      .primerNombre("Juan")
      .segundoNombre("Carlos")
      .primerApellido("Pérez")
      .segundoApellido("Gómez")
      .telefono("321654987")
      .direccion("Calle 123 #45-67")
      .ciudadResidencia("Bogotá")
      .build();

  public static final List<Usuario> DEMO_USUARIOS = List.of(USUARIO_DEMO_1);

}
