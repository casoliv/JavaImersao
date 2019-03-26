package br.com.targettrust.locadora.db;

import java.util.List;

import br.com.targettrust.locadora.entidades.Cliente;

public interface ClienteRepository {
	
	void insertCliente(Cliente funcionario);
	
	void updateCliente(Cliente funcionario);
	
	List<Cliente> listClientes();
	
	void delete(String login);

}
