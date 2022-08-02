package com.ciandt.escola.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    )
    private Set<Disciplina> disciplinas;

}
