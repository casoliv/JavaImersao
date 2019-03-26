package br.com.targettrust.locadora.input;

import java.util.Scanner;

import br.com.targettrust.locadora.db.ClienteRepository;
import br.com.targettrust.locadora.db.ClienteRepositoryImpl;
import br.com.targettrust.locadora.entidades.Cliente;

public class ClienteInput {
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Cliente cliente = new Cliente();
			System.out.println("Informe o Login");
			cliente.setLogin(scanner.next());
			System.out.println("Informe a senha");
			cliente.setSenha(scanner.next());
			System.out.println("Informe o nome");
			cliente.setNome(scanner.next());
			System.out.println("Informe a sobrenome");
			cliente.setSobrenome(scanner.next());
			System.out.println("Informe o cpf");
			cliente.setCpf(scanner.next());
			System.out.println("Informe o endereço");
			cliente.setEndereco(scanner.next());
			ClienteRepository clienteRepository = new ClienteRepositoryImpl();
			clienteRepository.insertCliente(cliente);
			
			scanner.close();
		}

}
