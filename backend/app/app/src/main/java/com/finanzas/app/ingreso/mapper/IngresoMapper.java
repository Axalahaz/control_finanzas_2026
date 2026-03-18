package com.finanzas.app.ingreso.mapper;

import org.springframework.stereotype.Component;

import com.finanzas.app.ingreso.dto.CrearIngresoRequest;
import com.finanzas.app.ingreso.dto.IngresoResponse;
import com.finanzas.app.ingreso.entity.Ingreso;
import com.finanzas.app.usuario.entity.Usuario;

@Component
public class IngresoMapper {

    public Ingreso toEntity(CrearIngresoRequest request, Usuario usuario) {
        return Ingreso.builder()
        		.monto(request.getMonto())
        		.descripcion(request.getDescripcion())
        		.usuario(usuario)
        		.build();

    }

    public IngresoResponse toResponse(Ingreso ingreso) {
    	return IngresoResponse.builder()
    			.id(ingreso.getId())
    			.monto(ingreso.getMonto())
        		.descripcion(ingreso.getDescripcion())
        		.fechaCreacion(ingreso.getFechaCreacion())
        		.fechaModificacion(ingreso.getFechaModificacion())
    			.build();
    }
}