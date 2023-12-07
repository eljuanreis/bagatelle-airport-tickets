package control;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

import contracts.Control;
import dao.FlightDAO;
import entity.Airline;
import entity.Flight;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utils.ParseDate;
import utils.ParseTime;

public class FlightControl implements Control {
	
//	private StringProperty airline = new SimpleStringProperty();
	private StringProperty airplane = new SimpleStringProperty();
	private StringProperty number = new SimpleStringProperty();
	private StringProperty boardingTime = new SimpleStringProperty();
	private StringProperty departureTime = new SimpleStringProperty();
	private StringProperty arrivalTime = new SimpleStringProperty();
	private StringProperty departureAirport = new SimpleStringProperty();
	private StringProperty destinationAirport = new SimpleStringProperty();
	private StringProperty gate = new SimpleStringProperty();
	
	protected Flight makeEntity() {
		Flight f = new Flight();
		
//		f.setAirline(null); // Fazer mecanismo de busca do objeto Airline
		f.setAirplane(this.airplane.get());
		f.setNumber(this.number.get());
		f.setBoardingTime(ParseTime.toLocalTime(this.boardingTime.get()));
		f.setDepartureTime(ParseTime.toLocalTime(this.departureTime.get()));
		f.setArrivalTime(ParseTime.toLocalTime(this.arrivalTime.get()));
		f.setDepartureAirport(this.departureAirport.get());
		f.setDestinationAirport(this.destinationAirport.get());
		f.setGate(this.gate.get());
		
		return f;
	}
	
	public void save() {
		FlightDAO dao = new FlightDAO(makeEntity());
		dao.create();
	}
	
	public void index() {
		ResultSet data = new FlightDAO().index();
	}
}
