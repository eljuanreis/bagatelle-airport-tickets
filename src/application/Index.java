package application;

import dao.AirlineDAO;
import dao.FlightDAO;
import dao.PassengerDAO;
import dao.TicketDAO;
import database.DBManager;
import entity.Airline;
import entity.Flight;
import entity.Passenger;
import entity.Ticket;
import utils.ParseDate;
import utils.ParseTime;

public class Index {

	public static void main(String[] args) {
		
		// Iniciando servico de banco de dados
		try {			
			DBManager db = DBManager.getInstance();
			db.testConnection();
			
			Passenger p = new Passenger();
			p.setId(1);
			p.setName("aa");
			p.setCpf("aaa");
			p.setPhone("123");
			p.setEmail("aasd");
//			p.setBirthDate(ParseDate.toDatetime("01/01/2000"));
//			
////			
//			PassengerDAO pd = new PassengerDAO(p);
//			pd.create();
//			pd.index();
			
			Airline a = new Airline();
			a.setId(1);
			a.setName("Gol");
//			System.out.println(a.getName());
//			AirlineDAO ad = new AirlineDAO(a);
//			ad.create();
//			ad.index();
			
			Flight f = new Flight();
			f.setId(7);
			f.setAirline(a);
			f.setAirplane("Boeing 737");
			f.setNumber("G70787");
			f.setDate(ParseDate.toDatetime("06/12/2023"));
			f.setBoardingTime(ParseTime.toLocalTime("18:00"));
			f.setDepartureTime(ParseTime.toLocalTime("19:00"));
			f.setArrivalTime(ParseTime.toLocalTime("20:00"));
			f.setDepartureAirport("SBGR");
			f.setDestinationAirport("SBRJ");
			f.setGate("1A");
//			
//			FlightDAO fd = new FlightDAO(f);
//			fd.create();
//			fd.index();
			
			Ticket t = new Ticket();
			t.setFlight(f);
			t.setPassenger(p);
			t.setSeat("33A");
			t.setSeatClass("Economy Class");
			
			TicketDAO td = new TicketDAO(t);
			td.create();
			td.index();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Lançar telas da aplicação
	}
}
