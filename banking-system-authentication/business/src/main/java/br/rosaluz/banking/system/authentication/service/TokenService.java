package br.rosaluz.banking.system.authentication.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    public String generateToken(Authentication authentication);
    public boolean isTokenValid(String token);
    public Long getIdUser(String token);
}
