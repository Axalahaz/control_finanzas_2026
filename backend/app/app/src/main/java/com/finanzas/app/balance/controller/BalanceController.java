package com.finanzas.app.balance.controller;

import com.finanzas.app.balance.dto.BalanceResponse;
import com.finanzas.app.balance.service.BalanceService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public BalanceResponse obtener(Authentication auth) {
        return balanceService.obtener(auth.getName());
    }
}