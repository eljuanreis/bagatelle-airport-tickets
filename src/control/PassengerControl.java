package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.Control;
import dao.PassengerDAO;
import entity.Passenger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ParseDate;

public class PassengerControl implements Control {

	private StringProperty name = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty phone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty birthday = new SimpleStringProperty();

	private ObservableList<Passenger> list = FXCollections.observableArrayList();

	public PassengerControl() {
		this.index();
	}
	
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
		Passenger p = makeEntity();
		PassengerDAO dao = new PassengerDAO(p);
		dao.create();
		list.add(p);
	}

	public void index() {
		ResultSet data = new PassengerDAO().index();
		
		try {
			while (data.next()) {
				Passenger p = toBoundary(data);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void search(String input) {
		ResultSet data = new PassengerDAO().search("name", name.get());
		
		name.set("");
		cpf.set("");
		phone.set("");
		email.set("");
		birthday.set("");
		list.clear();

		try {
			while (data.next()) {
				Passenger p = toBoundary(data);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected Passenger toBoundary(ResultSet data) throws SQLException {
		Passenger p = new Passenger();
		p.setName(data.getString("name"));
		p.setCpf(data.getString("cpf"));
		p.setPhone(data.getString("phone"));
		p.setEmail(data.getString("email"));
		p.setBirthDate(ParseDate.toDatetime(data.getString("birthday")));
		
		return p;
	}

	public SimpleStringProperty nameProperty() {
		return (SimpleStringProperty) name;
	}

	public SimpleStringProperty cpfProperty() {
		return (SimpleStringProperty) cpf;
	}

	public SimpleStringProperty phoneProperty() {
		return (SimpleStringProperty) phone;
	}

	public SimpleStringProperty emailProperty() {
		return (SimpleStringProperty) email;
	}

	public SimpleStringProperty birthdayProperty() {
		return (SimpleStringProperty) birthday;
	}

	public ObservableList<Passenger> getList() {
		return list;
	}

}
