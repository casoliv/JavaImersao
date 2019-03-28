package br.com.targettrust.locadora.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import br.com.targettrust.locadora.entidades.Equipamento;
import br.com.targettrust.locadora.exception.EquipamentoJaCadastradoException;

public class EquipamentoRepositoryImpl implements EquipamentoRepository{

	@Override
	public void insertEquipamento(Equipamento equipamento) {
		if(equipamento.getId() != null) {
			throw new IllegalArgumentException("Para inclus�o de ve�culo o id "
					+ " n�o deve ser informado");
		}
		if(equipamento.getDescricao() == null ||
				equipamento.getDescricao().equals("")) {
			throw new IllegalArgumentException("O campo descri��o � obrigat�rio");
		}

	String sql = "insert into EQUIPAMENTO (DESCRICAO ) values ( ? )";
	try {
		Connection connection = this.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, equipamento.getDescricao());
		ps.executeUpdate();
	}
	catch (PSQLException e) {
		throw new EquipamentoJaCadastradoException();
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}
	@Override
	public void updateEquipamento(Equipamento equipamento) {
		// TODO Auto-generated method stub
		String sql = "update EQUIPAMENTO set (descricao) "
				+ "values ( ? ) where id = ?";
		try {
			Connection connection = this.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, equipamento.getDescricao());
			ps.setInt(2, equipamento.getId());
			ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteEquipamento(Equipamento equipamento) {
		// TODO Auto-generated method stub
		String sql = "delete from EQUIPAMENTO where id = ?";
		try {
			Connection connection = this.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, equipamento.getId());
			ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Equipamento> list() {
		// TODO Auto-generated method stub
		String sql = "select * from EQUIPAMENTO";
		try {
			Connection connection = this.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Equipamento> equipamentos = new ArrayList<>();
			while(rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setId(rs.getInt("id"));
				equipamento.setDescricao(rs.getString("descricao"));
				equipamentos.add(equipamento);
			}
			return equipamentos;
		}
		catch (Exception e) {
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

}