package br.com.targettrust.locadora.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.targettrust.locadora.entidades.Moto;

public class MotoRepositoryImpl implements MotoRepository{

	@Override
	public void insertMoto(Moto moto) {
		try {
			String insert = "INSERT INTO moto(" + "	placa, marca, modelo, cor, cilindradas)"
					+ "	VALUES (? , ?, ?, ?, ?)";
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, moto.getPlaca());
			statement.setString(2, moto.getMarca());
			statement.setString(3, moto.getModelo());
			statement.setString(4, moto.getCor());
			statement.setInt(5, moto.getCilindradas());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Moto de placa " + moto.getPlaca() + "inserido com sucesso");
	}

	@Override
	public void updateMoto(Moto moto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Moto> listMotos() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from moto";
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			List<Moto> motos = new ArrayList<>();
			while (resultSet.next()) {
				Moto moto = new Moto();
				// popular
				moto.setCor(resultSet.getString("cor"));
				moto.setMarca(resultSet.getString("marca"));
				moto.setModelo(resultSet.getString("modelo"));
				moto.setPlaca(resultSet.getString("placa"));
				moto.setCilindradas(resultSet.getInt("cilindradas"));
				motos.add(moto);
			}
			return motos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String placa) {
		// TODO Auto-generated method stub

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

	
}
