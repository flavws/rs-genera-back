package br.com.rsgenera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean anonymous;

    private boolean status;

    @OneToOne
    @JoinColumn(name = "history_id", unique = true)
    private History history;

    @OneToOne(mappedBy = "person")
    private Scheduling scheduling;


}
