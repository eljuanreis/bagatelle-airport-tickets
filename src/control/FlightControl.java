package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import contracts.Control;
import dao.FlightDAO;
import dao.TicketDAO;
import entity.Airline;
import entity.Flight;
import entity.Ticket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ParseDate;
import utils.ParseTime;

public class FlightControl implements Control {
	
	private StringProperty airline = new SimpleStringProperty();
	private StringProperty airplane = new SimpleStringProperty();
	private StringProperty number = new SimpleStringProperty();
	private StringProperty date = new SimpleStringProperty();
	private StringProperty boardingTime = new SimpleStringProperty();
	private StringProperty departureTime = new SimpleStringProperty();
	private StringProperty arrivalTime = new SimpleStringProperty();
	private StringProperty departureAirport = new SimpleStringProperty();
	private StringProperty destinationAirport = new SimpleStringProperty();
	private StringProperty gate = new SimpleStringProperty();
	
	private ObservableList<Flight> list = FXCollections.observableArrayList();

	protected Flight makeEntity() {
		Flight f = new Flight();
		
		Airline a = new Airline();
		a.setId(Long.parseLong(this.airline.get()));
		
		f.setAirline(a);
		f.setAirplane(this.airplane.get());
		f.setNumber(this.number.get());
//		f.setDate(ParseDate.toString(null));
		f.setBoardingTime(ParseTime.toLocalTime(this.boardingTime.get()));
		f.setDepartureTime(ParseTime.toLocalTime(this.departureTime.get()));
		f.setArrivalTime(ParseTime.toLocalTime(this.arrivalTime.get()));
		f.setDepartureAirport(this.departureAirport.get());
		f.setDestinationAirport(this.destinationAirport.get());
		f.setGate(this.gate.get());
		
		return f;
	}
	
	public void save() {
		Flight f = makeEntity();
		FlightDAO dao = new FlightDAO(f);
		dao.create();
		list.add(f);
	}
	
	public void index() {
		ResultSet data = new FlightDAO().index();
		
		try {
			while (data.next()) {
				Flight t = toBoundary(data);
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Flight toBoundary(ResultSet data) throws NumberFormatException, SQLException {
		Flight f = new Flight();
		
		Airline a = new Airline();
		a.setId(Long.parseLong(data.getString("airline_id ")));
		
		f.setAirline(a);
		f.setAirplane(data.getString(""));
		f.setNumber(data.getString("number"));
		f.setBoardingTime(ParseTime.toLocalTime(data.getString("boardingTime")));
		f.setDepartureTime(ParseTime.toLocalTime(data.getString("departureTime ")));
		f.setArrivalTime(ParseTime.toLocalTime(data.getString("arrivalTime")));
		f.setDepartureAirport(data.getString("departureAirport"));
		f.setDestinationAirport(data.getString("destinationAirport"));
		f.setGate(data.getString("gate"));
		
		return f;
	}

	public StringProperty airlineProperty() {
		return airline;
	}

	public StringProperty getAirplane() {
		return airplane;
	}

	public StringProperty numberProperty() {
		return number;
	}

	public StringProperty dateProperty() {
		return number;
	}

	public StringProperty boardingTimeProperty() {
		return boardingTime;
	}

	public StringProperty departureTimeProperty() {
		return departureTime;
	}

	public StringProperty arrivalTimeProperty() {
		return arrivalTime;
	}

	public StringProperty departureAirportProperty() {
		return departureAirport;
	}

	public StringProperty destinationAirportProperty() {
		return destinationAirport;
	}

	public StringProperty gateProperty() {
		return gate;
	}

	public ObservableList<Flight> getList() {
		return list;
	}
}
