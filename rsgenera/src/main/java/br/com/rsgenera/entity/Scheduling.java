package br.com.rsgenera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String observation;

    private boolean status;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

}
