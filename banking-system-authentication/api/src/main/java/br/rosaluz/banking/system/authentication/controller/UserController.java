package br.rosaluz.banking.system.authentication.controller;

import br.rosaluz.banking.system.authentication.dto.UserDTO;
import br.rosaluz.banking.system.authentication.dto.UserResponseDTO;
import br.rosaluz.banking.system.authentication.model.User;
import br.rosaluz.banking.system.authentication.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/login", produces="application/json")
@Api(value="API REST Banking System")
@AllArgsConstructor
public class UserController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    private final ConversionService conversionService;


    @GetMapping("/checkAvailableLogin")
    public ResponseEntity<?> checkAvailableLogin(@RequestBody @Valid String login)
    {
        boolean valid = userService.validateLoginAlredyExist(login);
        return ResponseEntity.ok(new UserResponseDTO(valid));

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO) throws Exception {

        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userService.create(conversionService.convert(userDTO, User.class));


        return ResponseEntity.ok().build();

    }
}
