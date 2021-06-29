package br.com.senai.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;

public class CursoController {

	private Scanner tec;

	List<Curso> cursos = new ArrayList<>();

	public CursoController() {
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.println("\n");
		System.out.print("Informe a opção desejada -> ");
		return tec.nextInt();
	}

	public void menuCurso(List<Curso> cursos) {
		boolean sair = false;

		do {
			System.out.println("|----------- MENU CURSOS -----------|");
			System.out.println("|1 -> Cadastrar Cursos              |");
			System.out.println("|2 -> Lista de Cursos Cadastrados   |");
			System.out.println("|3 -> Editar Curso                  |");
			System.out.println("|4 -> Excluir Curso                 |");
			System.out.println("|-----------------------------------|");

			int opcao = leOpcao();

			switch (opcao) {

			case 1:
				System.out.println("\n");
				cursos.add(cadastrarCurso());
				break;

			case 2:
				listarCursos(cursos);
				break;

			case 3:
				editarCurso(cursos);
				break;

			case 4:
				excluirCurso(cursos, null);
				break;

			default:
				System.out.println("Opção Inválida!!!");
				break;
			}

			System.out.print("Deseja retornar ao MENU PRINCIPAL? [S/N] -> ");
			String resposta = tec.next();
			sair = resposta.equalsIgnoreCase("s") ? true : false;
			System.out.println("\n");

		} while (sair);
	}

	public Curso cadastrarCurso() {
		Curso curso = new Curso();

		System.out.println("----- Cadastrar Cursos -----");
		System.out.println("\n");

		System.out.print("Informe o nome do curso: ");
		curso.setNomeCurso(tec.next());

		System.out.println("\n");

		return curso;
	}

	public List<Curso> listarCursos(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("\n");
			System.out.println("A lista está vazia, cadastre algum produto!");
			System.out.println("\n");
			return null;
		}

		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------------------------------------------------------- CURSOS CADASTRADOS -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");

		System.out.printf("| %2s | %50s | \n", "ID", "Curso");

		for (int i = 0; i < cursos.size(); i++) {
			System.out.printf("| %2d | %49s | \n", i + 1, cursos.get(i).getNomeCurso());
		}

		System.out.println("\n");

		return cursos;
	}

	public List<Curso> editarCurso(List<Curso> cursos) {
		Curso curso = new Curso();

		listarCursos(cursos);

		if (cursos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o ID do produto para editar -> ");
		int idCurso = tec.nextInt() - 1;
		System.out.println("\n");

		System.out.println("|--- Campos a serem editados ---|");
		System.out.println("|1 -> Nome do curso             |");
		System.out.println("|-------------------------------|");
		System.out.println("\n");
		System.out.print("Informe o campo que deseja editar -> ");
		int opcao = tec.nextInt();
		System.out.println("\n");

		switch (opcao) {

		case 1:
			System.out.println("---- Editar o nome do curso cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe novamente  o novo do curso -> ");
			curso.setNomeCurso(tec.next());

			cursos.set(idCurso, curso);

			System.out.println("\n");

			break;

		default:
			System.out.println("Opção Inválida!!!!");
			break;
		}

		return cursos;
	}

	public void excluirCurso(List<Curso> cursos, List<Aluno> alunos) {
		listarCursos(cursos);

		if (cursos.isEmpty() || alunos.isEmpty()) {
			System.out.println("\n");
			System.out.println("Impossível realizar a exclusão do Curso pois há um aluno cursando o mesmo!!");
			System.out.println("\n");
			return;
		}

		System.out.println("--------------------------------------------------------------------------------------------------------------------- EXCLUIR CURSO -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");

		System.out.print("Informe o ID do curso que deseja excluir -> ");
		int idCurso = tec.nextInt() - 1;
		System.out.println("\n");

		if (cursos.size() <= idCurso) {
			System.out.println("\n");
			System.out.println("Curso não cadastrado!!");
			System.out.println("\n");
			return;
		}

		cursos.remove(idCurso);
	}
}
