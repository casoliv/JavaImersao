package br.com.targettrust.locadora.db.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import br.com.targettrust.locadora.db.CarroRepository;
import br.com.targettrust.locadora.db.CarroRepositoryImpl;
import br.com.targettrust.locadora.entidades.Carro;

public class CarroRepositoryTest {
	private CarroRepository carroRepository = new CarroRepositoryImpl();
	
	@Test
	public void basicInsertTest() throws Exception {
		// Arrange
		Carro carro = new Carro();
		carro.setMarca("Marca de teste");
		carro.setModelo("Modelo de teste");
		carro.setAno(1996);
		carro.setPlaca("ASD-1234");
		carro.setCor("Azul");
		carro.setPortas(4);
		// Act
		carroRepository.insertCarro(carro);
		// Assert
		List<Carro> qarros = carroRepository.list();
		boolean encontrou = false;
		for(Carro e : Carros) {
			if(e.getPlaca().equals(carro.getPlaca())) {
				carroRepository.deleteCarro(e);
				encontrou = true;
			}
		}
		Assert.assertTrue(encontrou);
	}

}
