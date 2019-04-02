package br.com.targettrust.locadora.db.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.targettrust.locadora.db.MotoRepository;
import br.com.targettrust.locadora.db.MotoRepositoryImpl;
import br.com.targettrust.locadora.entidades.Moto;
import br.com.targettrust.locadora.exception.PlacaJaCadastradaException;
import br.com.targettrust.locadora.exception.VeiculoNaoEncontradoException;

public class MotoRepositoryTest {
	
	private MotoRepository motoRepository = new MotoRepositoryImpl();
	
	@Before
	public void setup() {
		motoRepository.delete("PPP-1234");
		motoRepository.delete(9999);
	}
	
	@After
	public void cleanUp() {
		motoRepository.delete("PPP-1234");		
	}
	
	@Test
	public void basicInsert() {
		// Arrange
		Moto moto = new Moto();
		moto.setAno(2001);
		moto.setCor("Prata");
		moto.setMarca("Suzuki");
		moto.setModelo("GT");
		moto.setPlaca("PPP-1234");
		moto.setCilindradas(750);
		// Act
		motoRepository.insertMoto(moto);
		// Assert
		Moto motoDb = motoRepository.findByPlaca(moto.getPlaca());
		Assert.assertNotNull(motoDb);
		Assert.assertNotNull(motoDb.getId());
		// Clean-up
		motoRepository.delete(moto.getPlaca());
	}
	
	@Test(expected=PlacaJaCadastradaException.class)
	public void insertPlacaDuplicadaDeveRetornarErro() {
		// Arrange
		Moto moto1 = new Moto();
		moto1.setAno(2001);
		moto1.setCor("Prata");
		moto1.setMarca("Suzuki");
		moto1.setModelo("GT");
		moto1.setPlaca("PPP-1234");
		moto1.setCilindradas(750);
	
		motoRepository.insertMoto(moto1);
		// Act
		motoRepository.insertMoto(moto1);
		// Assert
		
	}
	
	@Test
	public void basicUpdate() {
		//Arrange
		Moto moto = new Moto();
		moto.setAno(2001);
		moto.setCor("Prata");
		moto.setMarca("Suzuki");
		moto.setModelo("GT");
		moto.setPlaca("PPP-1234");
		moto.setCilindradas(750);
		motoRepository.insertMoto(moto);
		moto.setId(motoRepository.findByPlaca(moto.getPlaca()).getId());
		moto.setCor("Preto");
		//Act
		motoRepository.updateMoto(moto);
		//Assert
		Moto motoDb = motoRepository.findByPlaca(moto.getPlaca());
		Assert.assertEquals(motoDb.getCor(), moto.getCor());		
	}
	
	@Test(expected=VeiculoNaoEncontradoException.class)
	public void updateDeVeiculoInexistenteDeveLancarErro() {
		// Arrange
		Moto moto = new Moto();
		moto.setAno(2001);
		moto.setCor("Prata");
		moto.setMarca("Suzuki");
		moto.setModelo("GT");
		moto.setPlaca("PPP-1234");
		moto.setCilindradas(750);
		moto.setId(9999);
		// Act
		motoRepository.updateMoto(moto);
		// Assert
		
	}

}