CREATE DATABASE airport;
use airport;

CREATE TABLE passengers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  phone VARCHAR(20),
  email VARCHAR(255),
  birthday DATE
);

CREATE TABLE airlines (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE flights (
  id INT PRIMARY KEY AUTO_INCREMENT,
  airline_id INT,
  number VARCHAR(20),
  date DATE,
  boardingTime TIME,
  departureTime TIME,
  arrivalTime TIME,
  departureAirport VARCHAR(255),
  destinationAirport VARCHAR(255),
  gate VARCHAR(10),
  FOREIGN KEY (airline_id) REFERENCES airlines(id)
);

CREATE TABLE tickets (
  id INT PRIMARY KEY AUTO_INCREMENT,
  passenger_id INT,
  flight_id INT,
  seat VARCHAR(10),
  seatClass VARCHAR(20),
  FOREIGN KEY (passenger_id) REFERENCES passengers(id),
  FOREIGN KEY (flight_id) REFERENCES flights(id)
);
