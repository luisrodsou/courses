CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE flight (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  company VARCHAR(80) NOT NULL,
  flight_date DATETIME NOT NULL,
  price DOUBLE NOT NULL,
  available_seats TINYINT UNSIGNED NOT NULL
);

INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 1", "2023-01-01 00:00:00.000", 1.23, 1);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 2", "2023-01-02 01:00:00.000", 4.56, 2);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 3", "2023-01-03 02:00:00.000", 7.89, 3);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 4", "2023-01-04 03:00:00.000", 0.12, 4);
INSERT INTO flight (company, flight_date, price, available_seats) VALUES ("Company 5", "2023-01-05 04:00:00.000", 3.45, 5);
