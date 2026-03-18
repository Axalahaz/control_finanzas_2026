package com.finanzas.app.balance.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BalanceResponse {

    private BigDecimal totalIngresos;
    private BigDecimal totalGastos;
    private BigDecimal balance;

    @Builder(toBuilder = true)
    private BalanceResponse(BigDecimal totalIngresos, BigDecimal totalGastos) {
        this.totalIngresos = totalIngresos;
        this.totalGastos = totalGastos;
        this.balance = totalIngresos.subtract(totalGastos);
    }
}