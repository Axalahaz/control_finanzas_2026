package com.finanzas.app.gasto.mapper;

import org.springframework.stereotype.Component;

import com.finanzas.app.gasto.dto.*;
import com.finanzas.app.gasto.entity.Gasto;
import com.finanzas.app.usuario.entity.Usuario;

@Component
public class GastoMapper {

    public Gasto toEntity(CrearGastoRequest request, Usuario usuario) {
        return Gasto.builder()
        		.monto(request.getMonto())
        		.descripcion(request.getDescripcion())
        		.categoria(request.getCategoria())
        		.usuario(usuario)
        		.build();

    }

    public GastoResponse toResponse(Gasto gasto) {
    	return GastoResponse.builder()
    			.id(gasto.getId())
    			.monto(gasto.getMonto())
        		.descripcion(gasto.getDescripcion())
        		.categoria(gasto.getCategoria())
        		.fechaCreacion(gasto.getFechaCreacion())
        		.fechaModificacion(gasto.getFechaModificacion())
    			.build();
    }
}