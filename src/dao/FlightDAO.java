package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.DAO;
import database.DBManager;
import entity.Flight;
import utils.ParseDate;
import utils.ParseTime;


public class FlightDAO implements DAO {
	
	private Flight flight;
	private DBManager db = DBManager.getInstance();

	public FlightDAO() {
		super();
	}
	
	public FlightDAO(Flight flight) {
		this.flight = flight;
	}
	
	public void create() {
		try {
			PreparedStatement stmt = db
					.prepare("INSERT INTO FLIGHTS ("
							+ "AIRPLANE,"
							+ "AIRLINE_ID,"
							+ "NUMBER,"
							+ "DATE,"
							+ "BOARDINGTIME,"
							+ "DEPARTURETIME,"
							+ "ARRIVALTIME,"
							+ "DEPARTUREAIRPORT,"
							+ "DESTINATIONAIRPORT,"
							+ "GATE) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			stmt.setString(1, flight.getAirplane());
			String airlineId = String.valueOf(flight.getAirline().getId());
			stmt.setString(2, airlineId);
			stmt.setString(3, flight.getNumber());
			stmt.setDate(4, ParseDate.asDate(flight.getDate()));
			stmt.setTime(5, ParseTime.asTime(flight.getBoardingTime()));
			stmt.setTime(6, ParseTime.asTime(flight.getDepartureTime()));
			stmt.setTime(7, ParseTime.asTime(flight.getArrivalTime()));
			stmt.setString(8, flight.getDepartureAirport());
			stmt.setString(9, flight.getDestinationAirport());
			stmt.setString(10, flight.getGate());

			db.insert(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet index() {
		try {
			PreparedStatement stmt = db.prepare("SELECT * FROM FLIGHTS");
			ResultSet rs = db.select(stmt);

			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public ResultSet search(String field, String input) {
		try {
			PreparedStatement stmt = db.prepare(
				"SELECT * FROM FLIGHTS WHERE " + field + " LIKE ?"
			);
			stmt.setString(1, "%" + input + "%");
			ResultSet rs = db.select(stmt);

			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
