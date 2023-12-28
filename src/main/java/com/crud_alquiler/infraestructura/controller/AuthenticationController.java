package com.crud_alquiler.infraestructura.controller;

import com.crud_alquiler.domain.usuario.entidades.Usuario;
import com.crud_alquiler.domain.usuario.entidades.dto.DataAdminAuthentication;
import com.crud_alquiler.infraestructura.security.DataJWTToken;
import com.crud_alquiler.infraestructura.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DataJWTToken> authenticationUser(@RequestBody @Valid DataAdminAuthentication dataAdminAuthentication){
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(dataAdminAuthentication.login(), dataAdminAuthentication.contrasenia());
        var authenticatedUser = authenticationManager.authenticate(authenticationToken);
        var JWTToken = tokenService.generatedToken((Usuario) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTToken));
    }
}
