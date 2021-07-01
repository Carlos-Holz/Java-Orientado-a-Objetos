package br.com.senai.aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class AlunoController {

	private Scanner tec;
	private CursoController cursoController;

	List<Aluno> alunos = new ArrayList<>();

	public AlunoController() {
		cursoController = new CursoController();
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.println("\n");
		System.out.print("Informe a opção desejada -> ");
		return tec.nextInt();
	}

	public void menuAluno(List<Aluno> alunos, List<Curso> cursos) {

		boolean sair = false;

		do {
			System.out.println("|----------- MENU ALUNOS -----------|");
			System.out.println("|1 -> Cadastrar Alunos              |");
			System.out.println("|2 -> Lista de Alunos Cadastrados   |");
			System.out.println("|3 -> Editar Alunos Cadastrados     |");
			System.out.println("|4 -> Excluir Alunos Cadastrados    |");
			System.out.println("|-----------------------------------|");

			int opcao = leOpcao();

			switch (opcao) {

			case 1:
				System.out.println("\n");
				alunos.add(cadastrarAluno(cursos));
				break;

			case 2:
				listarAlunos(alunos);
				break;

			case 3:
				editarAluno(alunos, cursos);
				break;

			case 4:
				excluirAluno(alunos);
				break;

			default:
				System.out.println("Opção Inválida!!!");
				break;
			}

			System.out.print("Deseja retornar ao MENU PRINCIPAL? [S/N] -> ");
			String resposta = tec.next();
			sair = resposta.equalsIgnoreCase("n") ? true : false;
			System.out.println("\n");

		} while (sair);
	}

	public Aluno cadastrarAluno(List<Curso> cursos) {

		if (cursos.isEmpty()) {
			System.out.println("\n");
			System.out.println(
					"Impossível realizar o cadastro de um aluno antes de efetuar o cadastro dos cursos em que o aluno pode se matricular. Retorne ao menu principal para cadastrar algum curso!");
			System.out.println("\n");
			return null;
		}

		cursoController.listarCursos(cursos);

		Aluno aluno = new Aluno();
		Curso curso = new Curso();

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------- CADASTRAR ALUNOS -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");

		System.out.print("Informe o ID do curso que o aluno deseja se matricular: ");
		int idCurso = tec.nextInt() - 1;
		System.out.println("\n");

		curso.setNomeCurso(cursos.get(idCurso).getNomeCurso());

		aluno.setCurso(curso);

		System.out.print("Informe o nome do aluno: ");
		tec.nextLine();
		aluno.setNomeAluno(tec.nextLine());

		System.out.print("Informe a idade do aluno: ");
		aluno.setIdadeAluno(tec.nextInt());

		System.out.print("Informe o país do aluno: ");
		aluno.setPais(tec.next());

		System.out.print("Informe o estado que o aluno reside: ");
		tec.nextLine();
		aluno.setEstado(tec.nextLine());

		System.out.print("Informe a cidade que o aluno reside: ");
		aluno.setCidade(tec.nextLine());

		System.out.println("\n");

		return aluno;
	}

	public List<Aluno> listarAlunos(List<Aluno> alunos) {

		if (alunos.isEmpty()) {
			System.out.println("\n");
			System.out.println("A lista está vazia, cadastre algum aluno!");
			System.out.println("\n");
			return null;
		}

		System.out.println("\n");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------- ALUNOS CADASTRADOS -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");

		System.out.printf("| %2s | %15s | %2s | %20s | %23s | %30s | %20s |\n", "ID", "Nome", "Idade", "País", "Estado",
				"Cidade", "Curso");

		for (int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %2d | %15s | %5d | %20s | %23s | %30s | %20s |\n", i + 1, alunos.get(i).getNomeAluno(),
					alunos.get(i).getIdadeAluno(), alunos.get(i).getPais(), alunos.get(i).getEstado(),
					alunos.get(i).getCidade(), alunos.get(i).getCurso().getNomeCurso());
		}
		System.out.println("\n");

		return alunos;
	}

	public List<Aluno> editarAluno(List<Aluno> alunos, List<Curso> cursos) {

		Aluno aluno = new Aluno();

		listarAlunos(alunos);

		if (alunos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o ID do aluno para editar -> ");
		int idAluno = tec.nextInt() - 1;
		System.out.println("\n");

		System.out.println("|--- Campos a serem editados ---|");
		System.out.println("|1 -> Nome do Aluno             |");
		System.out.println("|2 -> Idade                     |");
		System.out.println("|3 -> País                      |");
		System.out.println("|4 -> Estado                    |");
		System.out.println("|5 -> Cidade                    |");
		System.out.println("|6 -> Curso                     |");
		System.out.println("|-------------------------------|");
		System.out.println("\n");
		System.out.print("Informe o campo que deseja editar -> ");
		int opcao = tec.nextInt();
		System.out.println("\n");

		switch (opcao) {

		case 1:

			System.out.println("---- Editar o nome do aluno cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo nome do aluno -> ");
			tec.nextLine();
			aluno.setNomeAluno(tec.nextLine());

			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());

			alunos.set(idAluno, aluno);
			System.out.println("\n");

			break;

		case 2:

			System.out.println("---- Editar a idade do aluno cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe a nova idade do aluno -> ");
			aluno.setIdadeAluno(tec.nextInt());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());

			alunos.set(idAluno, aluno);
			System.out.println("\n");

			break;

		case 3:

			System.out.println("---- Editar o nome do país cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo país do aluno -> ");
			tec.nextLine();
			aluno.setPais(tec.nextLine());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());

			alunos.set(idAluno, aluno);
			System.out.println("\n");

			break;

		case 4:

			System.out.println("---- Editar o nome do estado cadastrado ----");
			System.out.println("\n");
			System.out.print("Informe o novo nome do estado -> ");
			tec.nextLine();
			aluno.setEstado(tec.nextLine());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setCidade(alunos.get(idAluno).getCidade());
			aluno.setCurso(alunos.get(idAluno).getCurso());

			alunos.set(idAluno, aluno);
			System.out.println("\n");

			break;

		case 5:

			System.out.println("---- Editar o nome da cidade cadastrada ----");
			System.out.println("\n");
			System.out.print("Informe o novo nome da cidade -> ");
			tec.nextLine();
			aluno.setCidade(tec.nextLine());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCurso(alunos.get(idAluno).getCurso());

			alunos.set(idAluno, aluno);
			System.out.println("\n");

			break;

		case 6:
			System.out.println("---- Editar o nome do curso em que o aluno foi matriculado ----");
			System.out.println("\n");
			cursoController.listarCursos(cursos);
			System.out.println("\n");
			System.out.print("Informe o ID do novo do curso -> ");
			aluno.setCurso(cursos.get(tec.nextInt() - 1));

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(idAluno).getIdadeAluno());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);
			System.out.println("\n");

			break;

		default:
			System.out.println("Opção Inválida!!!!");
			break;
		}

		return alunos;
	}

	public void excluirAluno(List<Aluno> alunos) {

		listarAlunos(alunos);

		if (alunos.isEmpty()) {
			return;
		}

		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------- EXCLUIR ALUNO -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");

		System.out.print("Informe o ID do aluno que deseja excluir -> ");
		int idAluno = tec.nextInt() - 1;
		System.out.println("\n");

		if (alunos.size() <= idAluno) {
			System.out.println("\n");
			System.out.println("Aluno não cadastrado!!");
			System.out.println("\n");
			return;
		}

		alunos.remove(idAluno);
	}
}
