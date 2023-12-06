package application;

import dao.AirlineDAO;
import dao.FlightDAO;
import dao.PassengerDAO;
import database.DBManager;
import entity.Airline;
import entity.Flight;
import entity.Passenger;
import utils.ParseDate;
import utils.ParseTime;

public class Index {

	public static void main(String[] args) {
		
		// Iniciando servico de banco de dados
		try {			
			DBManager db = DBManager.getInstance();
			db.testConnection();
			
//			Passenger p = new Passenger();
//			p.setName("aa");
//			p.setCpf("aaa");
//			p.setPhone("123");
//			p.setEmail("aasd");
//			
//			PassengerDAO pd = new PassengerDAO(p);
//			pd.create();
//			
//			pd.index();
			
			Airline a = new Airline();
			a.setName("gol");
			a.setId(2);
			AirlineDAO ad = new AirlineDAO(a);
			ad.create();
			ad.index();
			
			Flight f = new Flight();
			f.setAirline(a);
			f.setAirplane("Boeing 737");
			f.setNumber("G70787");
			f.setDate(ParseDate.toDatetime("06/12/2023 00:00"));
			f.setBoardingTime(ParseTime.toLocalTime("18:00"));
			f.setDepartureTime(ParseTime.toLocalTime("19:00"));
			f.setArrivalTime(ParseTime.toLocalTime("20:00"));
			f.setDepartureAirport("SBGR");
			f.setDestinationAirport("SBRJ");
			f.setGate("1A");
			
			FlightDAO fd = new FlightDAO(f);
			fd.create();
			fd.index();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Lançar telas da aplicação
	}
}
