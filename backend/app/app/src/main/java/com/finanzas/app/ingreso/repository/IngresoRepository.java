package com.finanzas.app.ingreso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.app.ingreso.entity.Ingreso;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

    List<Ingreso> findByUsuarioEmail(String email);
}