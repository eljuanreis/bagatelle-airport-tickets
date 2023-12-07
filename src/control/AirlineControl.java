package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import contracts.Control;
import dao.AirlineDAO;
import dao.PassengerDAO;
import entity.Airline;
import entity.Passenger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ParseDate;

public class AirlineControl implements Control {
	
	private StringProperty name = new SimpleStringProperty();
	
	private ObservableList<Airline> list = FXCollections.observableArrayList();
	
	public AirlineControl() {
		this.index();
	}
	
	protected Airline makeEntity() {
		Airline a = new Airline();
		a.setName(this.name.get());
		
		return a;
	}
	
	public void save() {
		Airline a = makeEntity();
		AirlineDAO dao = new AirlineDAO(a);
		dao.create();
		list.add(a);
	}
	
	public void index() {
		ResultSet data = new AirlineDAO().index();
		
		try {
			while (data.next()) {
				Airline a = toBoundary(data);
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void search(String input) {
		ResultSet data = new AirlineDAO().search("name", name.get());
		
		name.set("");
		list.clear();

		try {
			while (data.next()) {
				Airline a = new Airline();
				a.setName(data.getString("name"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected Airline toBoundary(ResultSet data) throws SQLException {
		Airline a = new Airline();
		a.setName(data.getString("name"));
		a.setId(Long.parseLong(data.getString("id")));
		
		return a;
	}
	
	public SimpleStringProperty nameProperty() {
		return (SimpleStringProperty) name;
	}
	
	public ObservableList<Airline> getList() {
		return list;
	}
}
