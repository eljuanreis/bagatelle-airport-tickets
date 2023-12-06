CREATE DATABASE airport;
use airport;

CREATE TABLE passenger (
  id INT PRIMARY KEY AUTO_INCREMENT,
  passengerName VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  phone VARCHAR(20),
  email VARCHAR(255),
  birthDate DATE
);

CREATE TABLE airline (
  id INT PRIMARY KEY AUTO_INCREMENT,
  airlineName VARCHAR(255) NOT NULL
);

CREATE TABLE flight (
  id INT PRIMARY KEY AUTO_INCREMENT,
  flightNumber VARCHAR(20),
  flightDate DATE,
  boardingTime TIME,
  departureTime TIME,
  arrivalTime TIME,
  departureAirport VARCHAR(255),
  destinationAirport VARCHAR(255),
  gate VARCHAR(10),
  FOREIGN KEY (airline_id) REFERENCES airline(id)
);

CRETE TABLE ticket (
  id INT PRIMARY KEY AUTO_INCREMENT,
  seat VARCHAR(10),
  seatClass VARCHAR(20),
  FOREIGN KEY (passenger_id) REFERENCES passenger(id),
  FOREIGN KEY (flight_id) REFERENCES flight(id)
);
