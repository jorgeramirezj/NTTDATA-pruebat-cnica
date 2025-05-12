package com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa.entity.VentaEntity;

@Repository
public interface VentaJpaRepository extends JpaRepository<VentaEntity, Long> {

  List<VentaEntity> findByIdEmpleado(Long idEmpleado);

}
