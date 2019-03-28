package br.com.targettrust.locadora.db.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.postgresql.util.PSQLException;

import br.com.targettrust.locadora.db.EquipamentoRepository;
import br.com.targettrust.locadora.db.EquipamentoRepositoryImpl;
import br.com.targettrust.locadora.entidades.Equipamento;
import br.com.targettrust.locadora.exception.EquipamentoJaCadastradoException;

public class EquipamentoRepositoryTest {
	
	private EquipamentoRepository equipamentoRepository = new EquipamentoRepositoryImpl();

	// testes de insert
	
	@Test
	public void basicInsertTest() throws Exception {
		// Arrange
		Equipamento equipamento = new Equipamento();
		equipamento.setDescricao("Equipamento de teste");
		// Act
		equipamentoRepository.insertEquipamento(equipamento);
		// Assert
		List<Equipamento> equipamentos = equipamentoRepository.list();
		boolean encontrou = false;
		for(Equipamento e : equipamentos) {
			if(e.getDescricao().equals(equipamento.getDescricao())) {
				equipamentoRepository.deleteEquipamento(e);
				encontrou = true;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equipamentoSemDescricaoDeveLancarErro() throws Exception {
		// Arrange
		Equipamento equipamento = new Equipamento();
		// Act
		equipamentoRepository.insertEquipamento(equipamento);
		// Assert - assert não é necessário aqui pois esperamos que uma exception seja lançada		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void equipamentoComIdPreenchidoDeveLancarErro() {
		// Arrange
		Equipamento equipamento = new Equipamento();
		equipamento.setDescricao("Descrição de teste");
		equipamento.setId(5);
		// Act
		equipamentoRepository.insertEquipamento(equipamento);
		// Assert - não é necessário		
	}
	
	@Test(expected=EquipamentoJaCadastradoException.class)
	public void descricaoDoEquipamentoExistenteDeveLancarErro() {
		// Arrange
		Equipamento equipamento1 = new Equipamento();
		equipamento1.setDescricao("Ar Condicionado");
		equipamentoRepository.insertEquipamento(equipamento1);
		Equipamento equipamento2 = new Equipamento();
		equipamento2.setDescricao(equipamento1.getDescricao());
		// Act 
		equipamentoRepository.insertEquipamento(equipamento2);
	}


	// Testes de update
	
	@Test(expected=IllegalArgumentException.class)
	public void updateEquipamentoSemDescricaoDeveLancarErro() throws Exception {
		// Arrange
		Equipamento equipamento = new Equipamento();
		// Act
		equipamentoRepository.updateEquipamento(equipamento);
		// Assert - assert não é necessário aqui pois esperamos que uma exception seja lançada		
	}

	@Test(expected=IllegalArgumentException.class)
	public void updateEquipamentoComIdPreenchidoDeveLancarErro() {
		// Arrange
		Equipamento equipamento = new Equipamento();
		equipamento.setDescricao("Descrição de teste");
		equipamento.setId(5);
		// Act
		equipamentoRepository.updateEquipamento(equipamento);
		// Assert - não é necessário		
	}	
	
	@Test(expected=EquipamentoJaCadastradoException.class)
	public void updateDescricaoDoEquipamentoExistenteDeveLancarErro() {
		// Arrange
		Equipamento equipamento1 = new Equipamento();
		equipamento1.setDescricao("Ar Condicionado");
		
		Equipamento equipamento2 = new Equipamento();
		equipamento2.setDescricao(equipamento1.getDescricao());
		// Act 
		equipamentoRepository.updateEquipamento(equipamento2);
	}

	// testes de delete
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteEquipamentoComIdInexistenteDeveLancarErro() {
		// Arrange
		Equipamento equipamento = new Equipamento();
		equipamento.setId(5);
		// Act
		equipamentoRepository.deleteEquipamento(equipamento);
		// Assert - não é necessário		
	}	
	
}