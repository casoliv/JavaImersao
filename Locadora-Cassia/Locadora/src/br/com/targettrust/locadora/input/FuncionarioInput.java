package br.com.targettrust.locadora.input;

import java.util.Scanner;

import br.com.targettrust.locadora.db.FuncionarioRepository;
import br.com.targettrust.locadora.db.FuncionarioRepositoryImpl;
import br.com.targettrust.locadora.entidades.Funcionario;

public class FuncionarioInput {
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Funcionario funcionario = new Funcionario();
			System.out.println("Informe o Login");
			funcionario.setLogin(scanner.next());
			System.out.println("Informe a senha");
			funcionario.setSenha(scanner.next());
			System.out.println("Informe o nome");
			funcionario.setNome(scanner.next());
			System.out.println("Informe a sobrenome");
			funcionario.setSobrenome(scanner.next());
			System.out.println("Informe o cpf");
			funcionario.setCpf(scanner.next());
			System.out.println("Informe a matricula");
			funcionario.setMatricula(scanner.next());
			FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl();
			funcionarioRepository.insertFuncionario(funcionario);
			
			scanner.close();
		}

}
