package br.com.targettrust.locadora.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.targettrust.locadora.entidades.Cliente;

public class ClienteRepositoryImpl implements ClienteRepository {

	@Override
	public void insertCliente(Cliente cliente) {
		try {
	 		String insert = "INSERT INTO cliente(" + "	login, senha, nome, sobrenome, endereco)"
					+ "	VALUES (? , ?, ?, ?, ?)";
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, cliente.getLogin());
			statement.setString(2, cliente.getSenha());
			statement.setString(3, cliente.getNome());
			statement.setString(4, cliente.getSobrenome());
			statement.setString(5, cliente.getEndereco());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Cliente de Login " + cliente.getLogin()+ "inserido com sucesso");
	}

	@Override
	public void updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> listClientes() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from cliente";
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			List<Cliente> clientes = new ArrayList<>();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				// popular
				cliente.setLogin(resultSet.getString("login"));
				cliente.setSenha(resultSet.getString("senha"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setSobrenome(resultSet.getString("sobrenome"));
				cliente.setEndereco(resultSet.getString("endereco"));
				clientes.add(cliente);
			}
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String login) {
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

