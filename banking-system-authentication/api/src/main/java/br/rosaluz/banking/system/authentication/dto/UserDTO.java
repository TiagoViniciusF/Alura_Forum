package br.rosaluz.banking.system.authentication.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private  String name;
    private String document;
    private String birthDate;
    private String motherName;
    private  String  login;
    private String  password;

}
