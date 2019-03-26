package media;

import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		String  next = scanner.next();
		Integer soma = 0;
		Integer ocorrencias = 0;
		
		do {
			soma = soma + Integer.parseInt(next);
			next = scanner.next();
			ocorrencias++;
		} while(!next.equals("="));
		
		System.out.println("Soma: " + soma);
		Double media = new Double(soma);
		System.out.println("Media: " + (media/ocorrencias));
		scanner.close();
	}

}
