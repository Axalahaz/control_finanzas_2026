package com.finanzas.app.balance.service;

import com.finanzas.app.ingreso.repository.IngresoRepository;

import lombok.RequiredArgsConstructor;

import com.finanzas.app.gasto.repository.GastoRepository;
import com.finanzas.app.balance.dto.BalanceResponse;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final IngresoRepository ingresoRepository;
    private final GastoRepository gastoRepository;

    public BalanceResponse obtener(String email) {

        BigDecimal totalIngresos = ingresoRepository
                .findByUsuarioEmail(email)
                .stream()
                .map(i -> i.getMonto())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalGastos = gastoRepository
                .findByUsuarioEmail(email)
                .stream()
                .map(g -> g.getMonto())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return BalanceResponse.builder()
        		.totalIngresos(totalIngresos)
        		.totalGastos(totalGastos)
        		.build();
    }
}