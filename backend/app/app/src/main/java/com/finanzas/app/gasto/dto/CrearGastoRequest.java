package com.finanzas.app.gasto.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class CrearGastoRequest {
    private BigDecimal monto;
    private String descripcion;
    private String categoria;
}