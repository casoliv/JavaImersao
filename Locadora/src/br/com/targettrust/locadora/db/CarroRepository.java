package br.com.targettrust.locadora.db;

import br.com.targettrust.locadora.entidades.Carro;

public interface CarroRepository {

	void insertCarro(Carro carro);
	
	void updateCarro(Carro carro);
	
	ListCarro listCarros();
	
	void delete (String placa);
	
}
