package com.finanzas.app.gasto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.app.gasto.entity.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {

    List<Gasto> findByUsuarioEmail(String email);
}