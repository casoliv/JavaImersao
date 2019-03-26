package br.com.targettrust.locadora.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.targettrust.locadora.entidades.Equipamento;

public class EquipamentoRepositoryImpl implements EquipamentoRepository{

	
	public void insertEquipamento(Equipamento equipamento) {
		try {
			String sql = "INSERT INTO equipamento(?)";
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, equipamento.getDescricao());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Equipamento inserido com sucesso");
	}

	
	public void updateEquipamento(Equipamento Equipamento) {
		// TODO Auto-generated method stub
        String sql = "UPDATE equipamento " 
        		   + "SET (descricao)"
        		   + "values (?) "
        		   + "WHERE id=?";
        try {
	        Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, Equipamento.getDescricao());
			statement.executeUpdate();
			statement.close();
			connection.close();
        } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Equipamento alterado com sucesso");
	}
        

	public List<Equipamento> listEquipamentos() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from equipamento";
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			List<Equipamento> equipamentos = new ArrayList<>();
			while (resultSet.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setDescricao(resultSet.getString("descricao"));
				equipamentos.add(equipamento);
			}
			return equipamentos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}



	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Locadora", "postgres",
					"postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}


	@Override
	public void deleteEquipamento(Equipamento equipamento) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Equipamento> list() {
		// TODO Auto-generated method stub
		return null;
	}


}

