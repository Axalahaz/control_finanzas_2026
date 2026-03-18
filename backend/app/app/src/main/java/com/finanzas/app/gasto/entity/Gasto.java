package com.finanzas.app.gasto.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.finanzas.app.usuario.entity.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;
    private String descripcion;
    private String categoria;
    
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    @ManyToOne
    private Usuario usuario;
    
    @PrePersist
    protected void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }

    @Builder
    private Gasto(
    		BigDecimal monto,
                  String descripcion,
                  String categoria,
                  Usuario usuario
        ) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    // **********************************************************************************************
    // <<<<<<<< METODOS PRIVADOS >>>>>>>>>
    // **********************************************************************************************
    
    // ----------------------------------------------------
    // CREAR
    
    public static Gasto crear(
    		BigDecimal monto,
            String descripcion,
            String categoria,
            Usuario usuario
        ) {
        return Gasto.builder()
                .monto(monto)
                .descripcion(descripcion)
                .categoria(categoria)
                .usuario(usuario)
                .build();
    }

    // ----------------------------------------------------
    // ACTUALIZAR

    public void actualizarMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void actualizarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void actualizarCategoria(String categoria) {
        this.categoria = categoria;
    }

    // opcional
    public void actualizarUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}