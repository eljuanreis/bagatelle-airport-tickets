package entity;

public class Ticket {
	private Passenger passenger;
	private Flight flight;
	private long id;
	private String seat;
	private String seatClass;
	
	public Ticket(Passenger passenger, Flight flight, long id, String seat, String seatClass) {
		super();
		this.passenger = passenger;
		this.flight = flight;
		this.id = id;
		this.seat = seat;
		this.seatClass = seatClass;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
}
