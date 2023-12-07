package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.Control;
import dao.TicketDAO;
import entity.Flight;
import entity.Passenger;
import entity.Ticket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TicketControl implements Control {

	private StringProperty passenger = new SimpleStringProperty();
	private StringProperty flight = new SimpleStringProperty();
	private StringProperty seat = new SimpleStringProperty();
	private StringProperty seatClass = new SimpleStringProperty();

	private ObservableList<Ticket> list = FXCollections.observableArrayList();

	public TicketControl() {
		this.index();
	}
	
	protected Ticket makeEntity() throws NumberFormatException, SQLException {
		Ticket t = new Ticket();
		
		Passenger p = new Passenger();
		p.setId(Long.parseLong(this.passenger.get()));
		
		Flight f = new Flight();
		f.setId(Long.parseLong(this.flight.get()));
		
		t.setPassenger(p); // Fazer mecanismo de busca do objeto Passenger
		t.setFlight(f); // Fazer mecanismo de busca do objeto Flight
		t.setSeat(this.seat.get());
		t.setSeatClass(this.seatClass.get());

		return t;
	}
	
	public void save() {
		Ticket p;
		try {
			p = makeEntity();
			TicketDAO dao = new TicketDAO(p);
			dao.create();
			list.add(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void index() {
		ResultSet data = new TicketDAO().index();
		
		try {
			while (data.next()) {
				Ticket t = toBoundary(data);
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Ticket toBoundary(ResultSet data) throws SQLException {
		Passenger p = new Passenger();
		p.setId(data.getLong("passenger_id"));
		
		Flight f = new Flight();
		f.setId(data.getLong("flight_id"));
		
		Ticket t = new Ticket();
		t.setFlight(f);
		t.setPassenger(p);
		
		t.setSeat(data.getString("seat"));
		t.setSeatClass(data.getString("seatClass"));
		
		return t;
	}
	
	public StringProperty passengerProperty() {
		return passenger;
	}

	public StringProperty flightProperty() {
		return flight;
	}

	public StringProperty seatProperty() {
		return seat;
	}

	public StringProperty seatClassProperty() {
		return seatClass;
	}

	public ObservableList<Ticket> getList() {
		return list;
	}
}
