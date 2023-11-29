package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.Keepable;

/**
 * Classe para manipulação do CRUD do banco de dados.
 * Utiliza o padrão de projeto Singleton para abrir e fechar conexões facilmente.
 * @author Juan Reis - Notebook
 *
 */
public class DBManager {
	
	private static DBManager instance;
	private Connection con;
	
	private static final String JDBC_URL=
			"jdbc:mariadb://localhost:3306/airport";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

	private DBManager() {
		super();
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		
		return instance;
	}
	
	public void testConnection() {
		System.out.println("Testando conexão com o banco");
		try {
			instance.open();
			System.out.println("Conexão feita com sucesso, teste finalizado\nFinalizando conexão com banco de dados");
		} catch (Exception e) {
			System.out.println("Erro ao conexar com banco de dado");

			e.printStackTrace();
		}

	}
	
	private void open() throws Exception {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (Exception e) {
			throw(e);
		}
	}
	
	private void close() throws SQLException {
		try {
			if (!con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			throw(e);
		}
	}
	
	public void insert(PreparedStatement stmt) {
		try {
			this.open();
			
			if (stmt == null) {
				this.close();

				return;
			}
			
			stmt.executeUpdate();
						
			this.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet select(PreparedStatement stmt) {
		try {
			this.open();
			
			if (stmt == null) {
				this.close();

				return null;
			}
									
			this.close();
			
			ResultSet rs = stmt.executeQuery();
			
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}	
}
