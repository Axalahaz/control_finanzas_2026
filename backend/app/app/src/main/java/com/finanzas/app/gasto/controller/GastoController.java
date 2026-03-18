package com.finanzas.app.gasto.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzas.app.gasto.dto.CrearGastoRequest;
import com.finanzas.app.gasto.dto.GastoResponse;
import com.finanzas.app.gasto.entity.Gasto;
import com.finanzas.app.gasto.mapper.GastoMapper;
import com.finanzas.app.gasto.service.GastoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService gastoService;
    private final GastoMapper gastoMapper;

 	// ----------------------------------------------------
    // CREAR
    
    @PostMapping
    public GastoResponse  crear(
    		@RequestBody CrearGastoRequest request, 
    		Authentication auth) {
    	Gasto gasto = gastoService.crear(request, auth.getName());

        return gastoMapper.toResponse(gasto);
    }

 	// ----------------------------------------------------
    // LISTAR
    
    @GetMapping
    public List<GastoResponse> listar(Authentication auth) {

        return gastoService.listar(auth.getName())
                .stream()
                .map(gastoMapper::toResponse)
                .toList();
    }
}