package br.com.targettrust.locadora.entidades;

import java.util.Scanner;

public class CarroInput2{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Carro   carro   = new Carro ();
		
		System.out.println("Digite a placa\n");
		String  vPlaca  = scanner.next(); 
		System.out.println("Digite a cor\n");
		String  vCor    = scanner.next(); 
		System.out.println("Digite a ano\n");
		Integer vAno    = Integer.valueOf(scanner.next());
		System.out.println("Digite a marca\n");
		String  vMarca  = scanner.next();
		System.out.println("Digite o modelo\n");
		String  vModelo = scanner.next();
		System.out.println("Digite a quantidade de portas\n");
		int     vPortas = Integer.valueOf(scanner.next());

		scanner.close();
		
		carro.setPlaca(vPlaca);
		carro.setCor(vCor);
		carro.setAno(vAno);
		carro.setMarca(vMarca);
		carro.setModelo(vModelo);
		carro.setPortas(vPortas);
	
		System.out.println("Placa : " + carro.getPlaca());
		System.out.println("Cor   : " + carro.getCor());
		System.out.println("Ano   : " + carro.getAno());
		System.out.println("Marca : " + carro.getMarca());
		System.out.println("Modelo: " + carro.getModelo());
		System.out.println("Portas: " + carro.getPortas());
		
	}
}

