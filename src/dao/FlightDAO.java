package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBManager;
import entity.Flight;
import utils.ParseDate;
import utils.ParseTime;


public class FlightDAO {
	
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
							+ "AIRLINE_ID,"
							+ "NUMBER,"
							+ "DATE,"
							+ "BOARDINGTIME,"
							+ "DEPARTURETIME,"
							+ "ARRIVALTIME,"
							+ "DEPARTUREAIRPORT,"
							+ "DESTINATIONAIRPORT,"
							+ "GATE) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			String airlineId = String.valueOf(flight.getAirline().getId());
			stmt.setString(1, airlineId);
			stmt.setString(2, flight.getNumber());
			stmt.setDate(3, ParseDate.asDate(flight.getDate()));
			stmt.setTime(4, ParseTime.asTime(flight.getBoardingTime()));
			stmt.setTime(5, ParseTime.asTime(flight.getDepartureTime()));
			stmt.setTime(6, ParseTime.asTime(flight.getArrivalTime()));
			stmt.setString(7, flight.getDepartureAirport());
			stmt.setString(8, flight.getDestinationAirport());
			stmt.setString(9, flight.getGate());

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
