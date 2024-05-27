package br.com.rsgenera.dto;

import br.com.rsgenera.enums.RoleName;

public record CreateUserDto(String email,
                          String password,
                          RoleName role) {

}
