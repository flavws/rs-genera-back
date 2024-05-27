package br.com.rsgenera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String occupation_area;

    private String picture;

    private String crmCrp;

    private String plataform;

    private String password;

    private boolean status;

    @OneToMany(mappedBy = "profissional")
    private List<Scheduling> scheduling;
}
