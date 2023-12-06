package control;

import java.sql.ResultSet;

import contracts.Control;
import dao.PassengerDAO;
import entity.Passenger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utils.ParseDate;

public class PassengerControl implements Control {
	
	private StringProperty name = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty phone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty birthday = new SimpleStringProperty();
	
	protected Passenger makeEntity() {
		Passenger p = new Passenger();
		p.setName(this.name.get());
		p.setCpf(this.cpf.get());
		p.setPhone(this.phone.get());
		p.setEmail(this.email.get());
		p.setBirthDate(ParseDate.toDatetime(this.birthday.get()));
		
		return p;
	}
	
	public void save() {
		PassengerDAO dao = new PassengerDAO(makeEntity());
		dao.create();
	}
	
	public void index() {
		ResultSet data = new PassengerDAO().index();
	}
}
