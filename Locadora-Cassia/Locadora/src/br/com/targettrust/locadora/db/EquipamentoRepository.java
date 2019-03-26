package br.com.targettrust.locadora.db;

import java.util.List;

import br.com.targettrust.locadora.entidades.Equipamento;

public interface EquipamentoRepository {
	void insertEquipamento (Equipamento equipamento);
	void updateEquipamento (Equipamento equipamento);
	void deleteEquipamento (Equipamento equipamento);
	List<Equipamento> list();
	
}
