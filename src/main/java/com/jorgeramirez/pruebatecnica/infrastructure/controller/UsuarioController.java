package com.jorgeramirez.pruebatecnica.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgeramirez.pruebatecnica.domain.service.UsuarioService;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.mapper.UsuarioControllerMapper;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.request.UsuarioRequest;
import com.jorgeramirez.pruebatecnica.infrastructure.controller.response.UsuarioResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService usuarioService;
  private final UsuarioControllerMapper usuarioControllerMapper;

  @GetMapping("/{tipoDocumento}/{numeroDocumento}")
  public ResponseEntity<UsuarioResponse> getUsuario(
      @PathVariable String tipoDocumento,
      @PathVariable String numeroDocumento) {

    return ResponseEntity.ok(usuarioControllerMapper.toResponse(usuarioService
        .getUsuarioByTipoAndNumero(tipoDocumento, numeroDocumento)));
  }

  @PostMapping("/validar")
  public ResponseEntity<UsuarioResponse> validarUsuario(
      @Valid @RequestBody UsuarioRequest request) {

    return ResponseEntity.ok(usuarioControllerMapper.toResponse(
        usuarioService.getUsuarioByTipoAndNumero(request.getTipoDocumento(),
            request.getNumeroDocumento())));
  }

}
