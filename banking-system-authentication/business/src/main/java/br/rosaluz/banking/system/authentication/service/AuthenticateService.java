package br.rosaluz.banking.system.authentication.service;

import br.rosaluz.banking.system.authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticateService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userService.findByLogin(login);
        if(user.isPresent()){
            return user.get();
        }

        throw new UsernameNotFoundException("Dados inválidos!");
    }
}
