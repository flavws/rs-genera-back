package br.com.rsgenera.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;

    private String picture;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "person_role",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles;
}
