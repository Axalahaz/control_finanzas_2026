package com.finanzas.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtService jwtService;

    /**
     * Configuración principal de seguridad
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
		     // API REST → sin CSRF (No usás sesiones ni formularios)
		        // Solo es útil con cookies y sesiones.
            .csrf(csrf -> csrf.disable())
            
            // Configuración de endpoints
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // login público
                .anyRequest().authenticated()		 	 // todo lo demás protegido
            )
            
            // Agregamos el filtro JWT antes del filtro de login de Spring
            /*
             * Así:
             * 1- llega request
             * 2- se valida JWT
             * 3- se autentica el usuario
             * 4- el controller puede usar @AuthenticationPrincipal
             */
            .addFilterBefore(new JwtFilter(jwtService),
                    org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}