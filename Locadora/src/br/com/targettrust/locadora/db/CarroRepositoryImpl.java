package br.com.targettrust.locadora.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.transform.Result;

import br.com.targettrust.locadora.entidades.Carro;

public class CarroRepositoryImpl implements CarroRepository{

	@Override
	public void insertCarro(Carro carro) {
		try {
			String insert = "INSERT INTO carro(" + 
					"	placa, marca, modelo, cor, portas)" + 
					"	VALUES ('"+ carro.getPlaca()+"', '"+carro.getMarca()
							+ "', '"+carro.getModelo()+"', '"+carro.getCor()+"',"
							+ carro.getPortas()+")";
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
				"Carro de placa "+carro.getPlaca()+"inserido com sucesso");		
	}

	@Override
	public void updateCarro(Carro carro) {
		// TODO Auto-generated method stub
		
	}



	public ListCarro listCarros() {
		try {
			String sql = "select * from carro";
		    Connection connection =getConnection();
		    Statement statement = connection.createStatement();
		    ResultSet resultset =statement.executeQuery(sql);
		    ListCarro carro 
					
		}
		
	}
	
	@Override
	public void delete(String placa) {
		// TODO Auto-generated method stub
		
	}
		

	private Connection getConnection() {
		return null;
		
	}
	
}
