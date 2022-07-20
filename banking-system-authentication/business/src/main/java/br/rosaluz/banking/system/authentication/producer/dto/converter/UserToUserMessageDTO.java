package br.rosaluz.banking.system.authentication.producer.dto.converter;

import br.rosaluz.banking.system.authentication.model.User;
import br.rosaluz.banking.system.authentication.producer.dto.UserMessageDTO;

import java.util.Optional;

public class UserToUserMessageDTO {

    public static UserMessageDTO convert(User user) {
        return Optional.ofNullable(user).map(userChecked -> UserMessageDTO.builder()
                .id(userChecked.getId())
                .name(userChecked.getName())
                .document(userChecked.getDocument())
                .birthDate(userChecked.getBirthDate())
                .motherName(userChecked.getMotherName())
                .login(userChecked.getLogin())
                .password(userChecked.getPassword())
                .build()).orElse(null);
    }
}
