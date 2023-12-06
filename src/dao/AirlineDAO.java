package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBManager;
import entity.Airline;

public class AirlineDAO {
	
	private Airline airline;
	private DBManager db = DBManager.getInstance();

	public AirlineDAO() {
		super();
	}
	
	public AirlineDAO(Airline airline) {
		this.airline = airline;
	}

	public void create() {
		try {
			PreparedStatement stmt = db
					.prepare("INSERT INTO AIRLINES (NAME) VALUES (?)");
			stmt.setString(1, airline.getName());

			db.insert(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet index() {
		try {
			PreparedStatement stmt = db.prepare("SELECT * FROM AIRLINES");
			ResultSet rs = db.select(stmt);

			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}
