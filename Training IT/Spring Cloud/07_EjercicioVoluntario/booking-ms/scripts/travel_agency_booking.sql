CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE hotel (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80) NOT NULL UNIQUE,
  category VARCHAR(80) NOT NULL,
  price DOUBLE NOT NULL,
  available TINYINT UNSIGNED NOT NULL
);

CREATE TABLE flight (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  company VARCHAR(80) NOT NULL,
  flight_date DATETIME NOT NULL,
  price DOUBLE NOT NULL,
  available_seats TINYINT UNSIGNED NOT NULL
);

CREATE TABLE booking_status (
    id TINYINT UNSIGNED PRIMARY KEY,
    description VARCHAR(80) NOT NULL
);

CREATE TABLE booking (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  client_name VARCHAR(80) NOT NULL,
  dni CHAR(9) NOT NULL,
  hotel_id INT UNSIGNED NOT NULL,
  flight_id INT UNSIGNED NOT NULL,
  status_id TINYINT UNSIGNED NOT NULL,

  FOREIGN KEY (hotel_id) REFERENCES hotel (id),
  FOREIGN KEY (flight_id) REFERENCES flight (id),
  FOREIGN KEY (status_id) REFERENCES booking_status (id)
);

INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 1", "Category 1", 1.23, 1);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 2", "Category 2", 4.56, 1);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 3", "Category 1", 7.89, 1);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 4", "Category 2", 0.12, 0);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 5", "Category 3", 3.45, 0);

INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 1", "2023-01-01 00:00:00.000", 1.23, 1);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 2", "2023-01-02 01:00:00.000", 4.56, 2);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 3", "2023-01-03 02:00:00.000", 7.89, 3);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 4", "2023-01-04 03:00:00.000", 0.12, 4);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 5", "2023-01-05 04:00:00.000", 3.45, 5);

INSERT INTO booking_status (id, description) VALUES (1, "Pending flight");
INSERT INTO booking_status (id, description) VALUES (2, "Accepted");
INSERT INTO booking_status (id, description) VALUES (3, "Rejected");

INSERT INTO booking (client_name, dni, hotel_id, flight_id, status_id) VALUES ("Client 1", "12345678A", 1, 2, 1);
INSERT INTO booking (client_name, dni, hotel_id, flight_id, status_id) VALUES ("Client 2", "90123456B", 3, 4, 1);
INSERT INTO booking (client_name, dni, hotel_id, flight_id, status_id) VALUES ("Client 3", "78901234C", 5, 1, 1);
INSERT INTO booking (client_name, dni, hotel_id, flight_id, status_id) VALUES ("Client 4", "56789012D", 2, 3, 1);
INSERT INTO booking (client_name, dni, hotel_id, flight_id, status_id) VALUES ("Client 5", "34567890E", 4, 5, 1);
