package br.rosaluz.banking.system.authentication.processor;

import br.rosaluz.banking.system.authentication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserAccountProcessor {

    private UserService userService;

    public void process(String message) {
        userService.process(message);
    }

}
