package br.com.targettrust.locadora.input;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.targettrust.locadora.db.EquipamentoRepository;
import br.com.targettrust.locadora.db.EquipamentoRepositoryImpl;
import br.com.targettrust.locadora.entidades.Equipamento;

public class EquipamentoInput {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Equipamento equipamento = new Equipamento();
		System.out.println("Informe a descricao");
		equipamento.setDescricao(scanner.next());
		
		EquipamentoRepository equipamentoRepository = new EquipamentoRepositoryImpl();
		equipamentoRepository.insertEquipamento(equipamento);
		
		scanner.close();
	}	
}
