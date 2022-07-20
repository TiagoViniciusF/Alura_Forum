package br.rosaluz.banking.system.authentication.controller;

import br.rosaluz.banking.system.authentication.dto.LoginDTO;
import br.rosaluz.banking.system.authentication.dto.TokenDTO;
import br.rosaluz.banking.system.authentication.service.TokenService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/authentication", produces="application/json")
@Api(value="API REST Banking System")
@AllArgsConstructor
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping()
    public ResponseEntity<TokenDTO> authenticator(@RequestBody @Valid LoginDTO loginDTO)
    {
        UsernamePasswordAuthenticationToken dataLogin = loginDTO.converter();

        try{
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token,"Bearer"));

        }catch (AuthenticationException e){
            //TODO RETORNAR MENSAGEM CERTA DE ERRO NO USUARIO OU SENHA
            return ResponseEntity.badRequest().build();
        }
    }
}
