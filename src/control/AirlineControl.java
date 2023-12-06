package control;

import java.sql.ResultSet;

import contracts.Control;
import dao.AirlineDAO;
import entity.Airline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AirlineControl implements Control {
	private StringProperty name = new SimpleStringProperty();
	
	protected Airline makeEntity() {
		Airline a = new Airline();
		a.setName(this.name.get());
		
		return a;
	}
	
	public void save() {
		AirlineDAO dao = new AirlineDAO(makeEntity());
		dao.create();
	}
	
	public void index() {
		ResultSet data = new AirlineDAO().index();
	}
}
