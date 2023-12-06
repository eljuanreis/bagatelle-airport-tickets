package control;

import java.sql.ResultSet;

import contracts.Control;
import dao.TicketDAO;
import entity.Ticket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TicketControl implements Control {
//	private StringProperty passenger = new SimpleStringProperty();
//	private StringProperty flight = new SimpleStringProperty();
	private StringProperty seat = new SimpleStringProperty();
	private StringProperty seatClass = new SimpleStringProperty();

	
	protected Ticket makeEntity() {
		Ticket t = new Ticket();
		
//		t.setPassenger(null); // Fazer mecanismo de busca do objeto Passenger
//		t.setFlight(null); // Fazer mecanismo de busca do objeto Flight
		t.setSeat(this.seat.get());
		t.setSeatClass(this.seatClass.get());

		return t;
	}
	
	public void save() {
		TicketDAO dao = new TicketDAO(makeEntity());
		dao.create();
	}
	
	public void index() {
		ResultSet data = new TicketDAO().index();
	}
}
