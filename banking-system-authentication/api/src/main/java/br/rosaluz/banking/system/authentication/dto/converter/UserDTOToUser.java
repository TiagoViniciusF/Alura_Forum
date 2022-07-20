package br.rosaluz.banking.system.authentication.dto.converter;

import br.rosaluz.banking.system.authentication.dto.UserDTO;
import br.rosaluz.banking.system.authentication.model.User;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class UserDTOToUser implements Converter<UserDTO, User> {

    @Override
    public User convert(UserDTO userDTO) {
        return Optional.ofNullable(userDTO).map(userDTOChecked -> User.builder()
                .name(userDTOChecked.getName())
                .document(userDTOChecked.getDocument())
                .birthDate(userDTOChecked.getBirthDate())
                .motherName(userDTOChecked.getMotherName())
                .login(userDTOChecked.getLogin())
                .password(userDTOChecked.getPassword())
                .build()).orElse(null);
    }
}
