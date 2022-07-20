package br.rosaluz.banking.system.authentication.service;

import br.rosaluz.banking.system.authentication.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService{

    @Value("${bank.system.jwt.expiration}")
    private String expiration;

    @Value("${bank.system.jwt.secret}")
    private String secret;

    @Override
    public String generateToken(Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setIssuer("API do forum da Alura")
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + Long.parseLong(expiration)))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    @Override
    public boolean isTokenValid(String token) {
        try{

            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);

            return true;

        }catch(Exception e){
            return false;
        }

    }
    @Override
    public Long getIdUser(String token) {

        Claims claims =  Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

}
