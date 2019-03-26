package br.com.targettrust.locadora.input;

import java.util.Scanner;

import br.com.targettrust.locadora.db.CarroRepository;
import br.com.targettrust.locadora.db.CarroRepositoryImpl;
import br.com.targettrust.locadora.entidades.Carro;

public class CarroInput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Carro   carro   = new Carro ();
		
		System.out.println("Digite a placa");
		carro.setPlaca(scanner.next()); 
		System.out.println("Digite a cor");
		carro.setCor(scanner.next());
		System.out.println("Digite a ano");
		carro.setAno(scanner.nextInt());
		System.out.println("Digite a marca");
		carro.setMarca(scanner.next());
		System.out.println("Digite o modelo");
		carro.setModelo(scanner.next());
		System.out.println("Digite a quantidade de portas");
		carro.setPortas(scanner.nextInt());

		scanner.close();
		
		System.out.println("Placa : " + carro.getPlaca());
		System.out.println("Cor   : " + carro.getCor());
		System.out.println("Ano   : " + carro.getAno());
		System.out.println("Marca : " + carro.getMarca());
		System.out.println("Modelo: " + carro.getModelo());
		System.out.println("Portas: " + carro.getPortas());
		
		CarroRepository carroRepository = new CarroRepositoryImpl();
		carroRepository.insertCarro(carro);
		
	}

}
