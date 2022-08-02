package com.ciandt.escola;

import com.ciandt.escola.entities.Aluno;
import com.ciandt.escola.entities.Disciplina;
import com.ciandt.escola.repositories.AlunoRepository;
import com.ciandt.escola.repositories.DisciplinaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
class EscolaApplicationTests {
	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void criarAluno(){
		Aluno aluno = new Aluno();

		aluno.setNome("Rebeca");

		alunoRepository.save(aluno);
	}

	@Test
	void criarDisciplina() {
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("POO");
		disciplina.setCargaHoraria(60);

		disciplinaRepository.save(disciplina);
	}

	@Test
	void adicionarAlunoEmDisciplina() {
		Optional<Disciplina> result = disciplinaRepository.findById(2l);
		Disciplina disciplina;
		if(result.isPresent()) {
			disciplina = result.get();

			Aluno aluno = new Aluno();
			aluno.setNome("Joaquina");

			Aluno alunoComId = alunoRepository.save(aluno);
			alunoComId.setDisciplinas(Set.of(disciplina));

			alunoRepository.save(alunoComId);

//			disciplina.setAlunos(Set.of(alunoComId));
//			disciplinaRepository.save(disciplina);
		}
	}

}
