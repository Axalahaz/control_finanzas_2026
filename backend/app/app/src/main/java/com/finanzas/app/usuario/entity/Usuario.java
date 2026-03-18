package com.finanzas.app.usuario.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String password;

    private Boolean activo;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    private LocalDateTime fechaDesactivacion;

    @PrePersist
    protected void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.activo = true;
    }
    
    @PreUpdate
    protected void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }
    
    @Builder
    private Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    // **********************************************************************************************
    // <<<<<<<< METODOS PRIVADOS >>>>>>>>>
    // **********************************************************************************************
    
    // ----------------------------------------------------
    // CREAR
    
    public static Usuario crear(String nombre, String email, String password) {
        return Usuario.builder()
                .nombre(nombre)
                .email(email)
                .password(password)
                .build();
    }
    
    // ----------------------------------------------------
    // ACTUALIZAR
    
    public void actualizarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void actualizarEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void actualizarPassword(String password) {
        this.password = password;
    }
    
    // ----------------------------------------------------
    // ESTADO
    
    public void desactivar() {
        this.activo = false;
        this.fechaDesactivacion = LocalDateTime.now();
    }
    
    public void activar() {
        this.activo = true;
        this.fechaDesactivacion = null;
    }
}