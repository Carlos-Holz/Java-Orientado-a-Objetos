package br.com.holz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;
import br.com.senai.aluno.AlunoController;
import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class ProgramaPrincipal {

	public static void menuPrincipal() {
		System.out.println("|---------- MENU PRINCIPAL ----------|");
		System.out.println("|1 -> Alunos                         |");
		System.out.println("|2 -> Cursos                         |");
		System.out.println("|3 -> Finalizar Sistema              |");
		System.out.println("|------------------------------------|");

}

	public static void main(String[] args) {

		Scanner tec;
		tec = new Scanner(System.in);

		List<Aluno> alunos = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();

		AlunoController alunoController = new AlunoController();
		CursoController cursoController = new CursoController();

		boolean sair = false;

		do {

			ProgramaPrincipal.menuPrincipal();
			System.out.println("\n");
			System.out.print("Informe a opção desejada -> ");
			int opcao = tec.nextInt();
			System.out.println("\n");

			switch (opcao) {

			case 1:
				alunoController.menuAluno(alunos);
				break;

			case 2:
				cursoController.menuCurso(cursos, alunos);
				break;

			case 3:
				sair = true;

				break;

			default:
				System.out.println("\n");
				System.out.println("Opção Inválida!!");
				System.out.println("\n");
				break;

			}

		} while (!sair);

		System.out.println("\n");
		System.out.println("Sistema Finalizado!!!");

	}
}
