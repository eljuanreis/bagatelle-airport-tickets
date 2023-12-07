package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.DAO;
import database.DBManager;
import entity.Flight;
import entity.Passenger;
import entity.Ticket;
import utils.ParseDate;
import utils.ParseTime;

public class TicketDAO implements DAO {

	private Ticket ticket;
	private DBManager db = DBManager.getInstance();
	private Connection con;
	
	public TicketDAO() {
		super();
	}
	
	public TicketDAO(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public void create() {
		try {
			PreparedStatement stmt = db
					.prepare("INSERT INTO TICKETS ("
							+ "PASSENGER_ID,"
							+ "FLIGHT_ID,"
							+ "SEAT,"
							+ "SEATCLASS) "
							+ "VALUES (?, ?, ?, ?)");
			
			String passengerId = String.valueOf(ticket.getPassenger().getId());
			stmt.setString(1, passengerId);
			
			String flightId = String.valueOf(ticket.getPassenger().getId());
			stmt.setString(2, flightId);
			
			stmt.setString(3, ticket.getSeat());
			
			stmt.setString(4, ticket.getSeatClass());

			db.insert(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet index() {
		try {
			PreparedStatement stmt = db.prepare("SELECT * FROM TICKETS");
			ResultSet rs = db.select(stmt);

			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
