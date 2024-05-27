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
public class Profissional extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String occupation_area;

    private String picture;

    private String crmCrp;

    private String plataform;

    private String password;

    private boolean status;

    @OneToMany(mappedBy = "profissional")
    private List<Scheduling> scheduling;
}
