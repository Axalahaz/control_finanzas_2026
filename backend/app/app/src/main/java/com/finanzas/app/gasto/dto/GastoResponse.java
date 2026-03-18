package com.finanzas.app.gasto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GastoResponse {
    private Long id;
    private BigDecimal monto;
    private String descripcion;
    private String categoria;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
}