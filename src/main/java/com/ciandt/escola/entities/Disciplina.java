package com.ciandt.escola.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Column(name = "cargahoraria")
    private int cargaHoraria;

    @ManyToMany(mappedBy = "disciplinas", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Aluno> alunos;

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

}
