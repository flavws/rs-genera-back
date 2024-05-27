package br.com.rsgenera.dto;

import br.com.rsgenera.entity.Role;

import java.util.List;

public record RecoveryUserDto(Long id,

                              String email,

                              List<Role> roles) {
}
