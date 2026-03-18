package com.finanzas.app.config;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

/*
 * Intercepta Request
 * */
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    /**
     * Este filtro se ejecuta UNA VEZ por request
     * antes de llegar al controller
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) {

    	// Obtenemos el header Authorization
        String header = request.getHeader("Authorization");

        // Verificamos que exista y tenga el formato correcto
        if (header != null && header.startsWith("Bearer ")) {
        	
        	// Quitamos "Bearer "
            String token = header.substring(7);

            // Validamos el token
            if (jwtService.esValido(token)) {
            	
            	// Extraemos el email del token
                String email = jwtService.extraerEmail(token);

                // seteo del usuario en el contexto
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.emptyList()
                        );

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}