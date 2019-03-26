package br.com.targettrust.locadora.input;

import java.util.List;

import br.com.targettrust.locadora.db.FuncionarioRepository;
import br.com.targettrust.locadora.db.FuncionarioRepositoryImpl;
import br.com.targettrust.locadora.entidades.Funcionario;

public class FuncionarioOutput {
	public static void main(String[] args) {
		FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl();
		List<Funcionario> funcionarios = funcionarioRepository.listFuncionarios();
		System.out.println(funcionarios.size());
	}
}
