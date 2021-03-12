package com.example.testdb.demodb.persistence;

public class MetodoDAO {

	private static final MetodoDAO INSTANCE = new MetodoDAO();
	
	private static final String SELECT_ALL = "select * from db.userdb;";
	
	private static final String INSERT = "insert into db.userdb(nome, cognome) values ( ?, ?);";

	private MetodoDAO() {
	}

	public static MetodoDAO getInstance() {
		return INSTANCE;
	}
	
	/*public boolean insert(String nome, String cognome) {
		boolean flag = true;
		try (final Connection conn = DBManager.createConnection();
				final PreparedStatement statement = conn.prepareStatement(INSERT);) {
			
			statement.setString(1, nome);
			statement.setString(2, cognome);
			statement.execute();
			
		}catch(SQLException s) {
			s.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public List<Metodo> get() {
		final List<Metodo> utenti = new ArrayList<>();
		try (final Connection conn = DBManager.createConnection();
				final PreparedStatement statement = conn.prepareStatement(SELECT_ALL);) {

			statement.execute();
			ResultSet result = statement.getResultSet();
			
			while (result.next()) {
				final Metodo user = new Metodo();
				user.setId(result.getLong("id"));
				user.setNome(result.getString("nome"));
				user.setCognome(result.getString("cognome"));
				
				utenti.add(user);
				
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return utenti;
	}*/

}
