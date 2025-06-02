package com.example.projetoescola.models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.projetoescola.config.JwtService;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
    HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
    String authorization = request.getHeader("Authorization");
    if (authorization != null && authorization.startsWith("Bearer")) {
    String token = authorization.split(" ")[1];
    boolean isValid = jwtService.validarToken(token);
    if (isValid) {
    String loginUsuario = jwtService.obterLoginUsuario(token);
    UserDetails usuario =
    userDetailsService.loadUserByUsername(loginUsuario);
    UsernamePasswordAuthenticationToken user = new
    UsernamePasswordAuthenticationToken(usuario, null,
    usuario.getAuthorities());
    user.setDetails(new
    WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(user);
    }
    }
  //  filterChain.doFilter(request, response);
    }
}

