package br.com.targettrust.locadora.input;

import java.util.List;

import br.com.targettrust.locadora.db.ClienteRepository;
import br.com.targettrust.locadora.db.ClienteRepositoryImpl;
import br.com.targettrust.locadora.entidades.Cliente;

public class ClienteOutput {
	public static void main(String[] args) {
		ClienteRepository funcionarioRepository = new ClienteRepositoryImpl();
		List<Cliente> funcionarios = funcionarioRepository.listClientes();
		System.out.println(funcionarios.size());
	}
}
