package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.DAO;
import database.DBManager;
import entity.Passenger;
import utils.ParseDate;

public class PassengerDAO implements DAO {

	private Passenger passenger;
	private DBManager db = DBManager.getInstance();

	public PassengerDAO() {
		super();
	}
	
	public PassengerDAO(Passenger passenger) {
		this.passenger = passenger;
	}

	public void create() {
		try {
			PreparedStatement stmt = db
					.prepare("INSERT INTO PASSENGERS (NAME, CPF, PHONE, EMAIL, BIRTHDAY) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, passenger.getName());
			stmt.setString(2, passenger.getCpf());
			stmt.setString(3, passenger.getPhone());
			stmt.setString(4, passenger.getEmail());
			stmt.setDate(5, ParseDate.asDate(passenger.getBirthDate()));
			db.insert(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet index() {
		try {
			PreparedStatement stmt = db.prepare("SELECT * FROM PASSENGERS");
			ResultSet rs = db.select(stmt);

			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
