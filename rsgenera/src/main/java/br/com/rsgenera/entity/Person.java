package br.com.rsgenera.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String picture;

    private boolean anonymous;

    private boolean status;

    private String password;

    @OneToOne
    @JoinColumn(name = "history_id", unique = true)
    private History history;

    @OneToOne(mappedBy = "person")
    private Scheduling scheduling;


}
