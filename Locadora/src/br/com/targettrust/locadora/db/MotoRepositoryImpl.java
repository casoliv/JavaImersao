package br.com.targettrust.locadora.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import br.com.targettrust.locadora.entidades.Moto;

public class MotoRepositoryImpl implements MotoRepository{

	@Override
	public void insertMoto(Moto moto) {
		try {
			String insert = "INSERT INTO moto(" + 
					"	placa, marca, modelo, cor, cilinfradas)" + 
					"	VALUES ('"+ moto.getPlaca()+"', '"+moto.getMarca()
							+ "', '"+ moto.getModelo()+"', '"+moto.getCor()+"',"
							+ moto.getCilindradas()+")";
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Locadora", 
					"postgres", "postgres");
			Statement statement = connection.createStatement();
			statement.executeUpdate(insert);
			statement.close();
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(
				"Moto de placa "+moto.getPlaca()+" inserida com sucesso");		
	}
		

}

