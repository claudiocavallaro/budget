package com.example.testdb.demodb.persistence;

import com.example.testdb.demodb.model.Metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetodoDAO {

	private static final MetodoDAO INSTANCE = new MetodoDAO();
	
	private static final String SELECT_ALL = "select * from budget.metodo;";
	
	private static final String INSERT = "insert into budget.metodo(tipo) values (?);";

	private MetodoDAO() {
	}

	public static MetodoDAO getInstance() {
		return INSTANCE;
	}
	
	public boolean insert(String tipo) {
		boolean flag = true;
		try (final Connection conn = DBManager.createConnection();
			 final PreparedStatement statement = conn.prepareStatement(INSERT);) {
			
			statement.setString(1, tipo);
			statement.execute();
			
		}catch(SQLException s) {
			s.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public List<Metodo> get() {
		final List<Metodo> metodi = new ArrayList<>();
		try (final Connection conn = DBManager.createConnection();
				final PreparedStatement statement = conn.prepareStatement(SELECT_ALL);) {

			statement.execute();
			ResultSet result = statement.getResultSet();
			
			while (result.next()) {
				final Metodo metodo = new Metodo();
				metodo.setId(result.getLong("id"));
				metodo.setTipo(result.getString("tipo"));
				
				metodi.add(metodo);
				
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return metodi;
	}

}
