package br.rosaluz.banking.system.authentication.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDTO {

    private  String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UsernamePasswordAuthenticationToken converter() {

        return  new UsernamePasswordAuthenticationToken(login, password);
    }

}
