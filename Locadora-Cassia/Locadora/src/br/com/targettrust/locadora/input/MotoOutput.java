package br.com.targettrust.locadora.input;

import java.util.List;

import br.com.targettrust.locadora.db.MotoRepository;
import br.com.targettrust.locadora.db.MotoRepositoryImpl;
import br.com.targettrust.locadora.entidades.Moto;

public class MotoOutput {

	public static void main(String[] args) {
		MotoRepository motoRepository = new MotoRepositoryImpl();
		List<Moto> motos = motoRepository.list();
		System.out.println(motos.size());
	}
}
