package br.com.senai.aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoController {

	private Scanner tec;

	List<Aluno> alunos = new ArrayList<>();

	public AlunoController() {
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.println("\n");
		System.out.print("Informe a opção desejada -> ");
		return tec.nextInt();
	}

	public void menuAluno(List<Aluno> alunos) {

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

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

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
	
	public Aluno cadastrarAluno() {
		Aluno aluno = new Aluno();
		
		System.out.println("---------- CADASTRAR ALUNOS ----------");
		System.out.println("\n");
		
		System.out.print("Informe o nome do aluno: ");
		tec.nextLine();
		aluno.setNomeAluno(tec.nextLine());
		
		System.out.print("Informe a idade do aluno: ");
		aluno.setIdadeAluno(tec.nextInt());
		
		System.out.print("Informe o país do aluno: ");
		aluno.setPais(tec.next());
		
		System.out.print("Informe o estado que o aluno reside: ");
		aluno.setEstado(tec.next());
		
		System.out.print("Informe a cidade que o aluno reside: ");
		aluno.setCidade(tec.next());
		
		return aluno;
	}
	
	public List<Aluno> listarAlunos(List<Aluno> alunos){
		
		if(alunos.isEmpty()) {
			System.out.println("\n");
			System.out.println("A lista está vazia, cadastre algum aluno!");
			System.out.println("\n");
			return null;
		}
		
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------------------------------------------------------- ALUNOS CADASTRADOS -------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		System.out.printf("| %2s | %15s | %2s | %20s | %23s | %30s | \n",
				"ID" , "Nome" , "Idade" , "País" , "Estado" , "Cidade");
		
		for(int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %2d | %15s | %2d | %19s | %23s | %30s | \n",
					i+ 1,
					alunos.get(i).getNomeAluno(),
					alunos.get(i).getIdadeAluno(),
					alunos.get(i).getPais(),
					alunos.get(i).getEstado(),
					alunos.get(i).getCidade());
		}
		System.out.println("\n");
		
		return alunos;
	}
	
	
}
