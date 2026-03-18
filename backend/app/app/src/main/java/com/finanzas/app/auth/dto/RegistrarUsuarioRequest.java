package com.finanzas.app.auth.dto;

import lombok.Getter;

@Getter
public class RegistrarUsuarioRequest {
    private String nombre;
    private String email;
    private String password;
}