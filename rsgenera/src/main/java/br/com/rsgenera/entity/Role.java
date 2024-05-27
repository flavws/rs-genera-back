package br.com.rsgenera.entity;

import br.com.rsgenera.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleName authority;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
