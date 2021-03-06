package br.com.targettrust.locadora.input;

import java.util.Scanner;

import br.com.targettrust.locadora.entidades.Moto;

public class MotoInputCassia {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Moto   moto   = new Moto ();
		
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
		System.out.println("Digite as cilindradas\n");
		int     vCilindradas = Integer.valueOf(scanner.next());

		scanner.close();
		
		moto.setPlaca(vPlaca);
		moto.setCor(vCor);
		moto.setAno(vAno);
		moto.setMarca(vMarca);
		moto.setModelo(vModelo);
		moto.setCilindradas(vCilindradas);
		
		System.out.println("Placa : " + moto.getPlaca());
		System.out.println("Cor   : " + moto.getCor());
		System.out.println("Ano   : " + moto.getAno());
		System.out.println("Marca : " + moto.getMarca());
		System.out.println("Modelo: " + moto.getModelo());
		System.out.println("Cilindradas: " + moto.getCilindradas());
		
	}
}
