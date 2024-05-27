package br.com.rsgenera.service;

import br.com.rsgenera.dto.CreateUserDto;
import br.com.rsgenera.dto.LoginUserDto;
import br.com.rsgenera.dto.RecoveryJwtTokenDto;
import br.com.rsgenera.entity.Role;
import br.com.rsgenera.entity.User;
import br.com.rsgenera.infra.security.authentication.JwtTokenService;
import br.com.rsgenera.infra.security.config.SecurityConfiguration;
import br.com.rsgenera.infra.security.userDetails.UserDetailsImpl;
import br.com.rsgenera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    public void createUser(CreateUserDto createUserDto) {

        User newUser = User.builder()
                .email(createUserDto.email())
                .password(securityConfiguration.passwordEncoder().encode(createUserDto.password()))
                .roles((Set<Role>) List.of(Role.builder().authority(createUserDto.role()).build()))
                .build();

        userRepository.save(newUser);
    }
}