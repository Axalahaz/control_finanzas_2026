package com.finanzas.app.ingreso.controller;

import com.finanzas.app.ingreso.dto.CrearIngresoRequest;
import com.finanzas.app.ingreso.dto.IngresoResponse;
import com.finanzas.app.ingreso.entity.Ingreso;
import com.finanzas.app.ingreso.mapper.IngresoMapper;
import com.finanzas.app.ingreso.service.IngresoService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresos")
@RequiredArgsConstructor
public class IngresoController {

    private final IngresoService ingresoService;
    private final IngresoMapper ingresoMapper;

    // ----------------------------------------------------
    // CREAR
    
    @PostMapping
    public IngresoResponse crear(
    		@RequestBody CrearIngresoRequest request, 
    		Authentication auth) {

    	Ingreso ingreso = ingresoService.crear(request, auth.getName());

        return ingresoMapper.toResponse(ingreso);
    }

    // ----------------------------------------------------
    // LISTAR

    @GetMapping
    public List<IngresoResponse> listar(Authentication auth) {

    	return ingresoService.listar(auth.getName())
                .stream()
                .map(ingresoMapper::toResponse)
                .toList();
    }
}