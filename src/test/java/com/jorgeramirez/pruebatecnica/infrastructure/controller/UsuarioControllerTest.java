package com.jorgeramirez.pruebatecnica.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.jorgeramirez.pruebatecnica.domain.model.Usuario;
import com.jorgeramirez.pruebatecnica.domain.service.UsuarioService;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.mapper.UsuarioControllerMapper;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.request.UsuarioRequest;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.response.UsuarioResponse;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

  @InjectMocks
  private UsuarioController usuarioController;

  @Mock
  private UsuarioService usuarioService;

  private final UsuarioControllerMapper mapper =
      Mappers.getMapper(UsuarioControllerMapper.class);

  private final EasyRandom generator = new EasyRandom();

  @BeforeEach
  void setUp() {

    ReflectionTestUtils
        .setField(usuarioController, "usuarioControllerMapper", mapper);
  }

  @Test
  void testGetUsuario_Success() {

    Usuario usuario = generator.nextObject(Usuario.class);
    when(usuarioService.getUsuarioByTipoAndNumero(any(), any()))
        .thenReturn(usuario);

    ResponseEntity<UsuarioResponse> response =
        usuarioController.getUsuario("C", "123456789");

    assertNotNull(response.getBody());
    assertEquals(usuario.getPrimerNombre(),
        response.getBody().getPrimerNombre());
  }

  @Test
  void testValidarUsuario_Success() {

    Usuario usuario = generator.nextObject(Usuario.class);
    UsuarioRequest request = generator.nextObject(UsuarioRequest.class);

    when(usuarioService.getUsuarioByTipoAndNumero(any(), any()))
        .thenReturn(usuario);

    ResponseEntity<UsuarioResponse> response =
        usuarioController.validarUsuario(request);

    assertNotNull(response.getBody());
    assertEquals(usuario.getPrimerNombre(),
        response.getBody().getPrimerNombre());
  }

}
