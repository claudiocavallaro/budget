package com.claudiocavallaro.personal.budget.persistence;

import com.claudiocavallaro.personal.budget.model.Metodo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MetodoDAO {

	private static final MetodoDAO INSTANCE = new MetodoDAO();
	
	private static final String SELECT_ALL = "select * from budget.metodo;";
	private static final String SELECT_ID = "select id from budget.metodo where tipo = ?;";
	
	private static final String INSERT = "insert into budget.metodo(tipo) values (?);";

	private static final String fileName = "./sql/init.sql";

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

			FileOutputStream fos = new FileOutputStream(fileName, true);
			String toWrite = statement.toString() + ";\n";
			fos.write(toWrite.getBytes());
			fos.close();
		}catch(SQLException | FileNotFoundException s) {
			s.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
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

	public Long getId(String tipo) {
		Long id = null;
		try (final Connection conn = DBManager.createConnection();
			 final PreparedStatement statement = conn.prepareStatement(SELECT_ID);) {
			statement.setString(1, tipo);
			statement.execute();
			ResultSet result = statement.getResultSet();

			while (result.next()) {

				id = result.getLong("id");

			}
		} catch (SQLException s) {
			s.printStackTrace();
		}

		return id;
	}

}
