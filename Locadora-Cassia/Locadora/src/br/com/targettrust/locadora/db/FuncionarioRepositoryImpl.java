package br.com.targettrust.locadora.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.targettrust.locadora.entidades.Funcionario;

public class FuncionarioRepositoryImpl implements FuncionarioRepository {

	@Override
	public void insertFuncionario(Funcionario funcionario) {
		try {
	 		String insert = "INSERT INTO funcionario(" + "	login, senha, nome, sobrenome, matricula)"
					+ "	VALUES (? , ?, ?, ?, ?)";
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, funcionario.getLogin());
			statement.setString(2, funcionario.getSenha());
			statement.setString(3, funcionario.getNome());
			statement.setString(4, funcionario.getSobrenome());
			statement.setString(5, funcionario.getMatricula());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Funcionario de Matricula " + funcionario.getMatricula()+ "inserido com sucesso");
	}

	@Override
	public void updateFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Funcionario> listFuncionarios() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from funcionario";
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			List<Funcionario> funcionarios = new ArrayList<>();
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				// popular
				funcionario.setLogin(resultSet.getString("login"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setSobrenome(resultSet.getString("sobrenome"));
				funcionario.setMatricula(resultSet.getString("matricula"));
				funcionarios.add(funcionario);
			}
			return funcionarios;
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

