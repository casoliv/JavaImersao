package br.com.targettrust.locadora.db;

import java.util.List;

import br.com.targettrust.locadora.entidades.Funcionario;

public interface FuncionarioRepository {
	
	void insertFuncionario(Funcionario funcionario);
	
	void updateFuncionario(Funcionario funcionario);
	
	List<Funcionario> listFuncionarios();
	
	void delete(String login);

}

