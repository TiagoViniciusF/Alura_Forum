package br.rosaluz.banking.system.authentication.producer.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserMessageDTO {

    private Long id;
    private  String name;
    private String document;
    private String birthDate;
    private String motherName;
    private  String login;
    private String  password;

}
