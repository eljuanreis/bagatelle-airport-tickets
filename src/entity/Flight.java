package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	private String airplane;
	private long number;
	private LocalDate date;
	private LocalTime boardingTime;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private String departureAirport;
	private String destinationAirport;
	private String gate;
	
	public Flight(String airplane, long number, LocalDate date, LocalTime boardingTime,
			LocalTime departureTime, LocalTime arrivalTime, String departureAirport,
			String destinationAirport, String gate) {
		super();
		this.airplane = airplane;
		this.number = number;
		this.date = date;
		this.boardingTime = boardingTime;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureAirport = departureAirport;
		this.destinationAirport = destinationAirport;
		this.gate = gate;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(LocalTime boardingTime) {
		this.boardingTime = boardingTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}
	
}
