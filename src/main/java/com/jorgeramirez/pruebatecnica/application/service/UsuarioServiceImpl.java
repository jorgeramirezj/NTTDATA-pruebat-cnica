package com.jorgeramirez.pruebatecnica.application.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jorgeramirez.pruebatecnica.domain.dao.UsuarioDao;
import com.jorgeramirez.pruebatecnica.domain.exception.InvalidArgumentException;
import com.jorgeramirez.pruebatecnica.domain.exception.UsuarioNotFoundException;
import com.jorgeramirez.pruebatecnica.domain.model.Usuario;
import com.jorgeramirez.pruebatecnica.domain.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioDao usuarioDao;

  @Override
  public Usuario getUsuarioByTipoAndNumero(String tipoDocumento,
      String numeroDocumento) {

    validarTipoDocumento(tipoDocumento);
    validarNumeroDocumento(numeroDocumento);
    return usuarioDao.getUsuarioByTipoAndNumero(tipoDocumento, numeroDocumento)
        .orElseThrow(
            () -> new UsuarioNotFoundException("Usuario no encontrado"));
  }

  private void validarTipoDocumento(String tipoDocumento) {

    if (!StringUtils.hasText(tipoDocumento)) {
      throw new InvalidArgumentException(
          "El tipo de documento es obligatorio.");
    }
  }

  private void validarNumeroDocumento(String numeroDocumento) {

    if (!StringUtils.hasText(numeroDocumento)) {
      throw new InvalidArgumentException(
          "El número de documento es obligatorio.");
    }
  }
}
