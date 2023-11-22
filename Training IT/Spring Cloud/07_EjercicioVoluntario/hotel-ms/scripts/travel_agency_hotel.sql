CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE hotel (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80) NOT NULL UNIQUE,
  category VARCHAR(80) NOT NULL,
  price DOUBLE NOT NULL,
  available TINYINT UNSIGNED NOT NULL
);

INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 1", "Category 1", 1.23, 1);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 2", "Category 2", 4.56, 1);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 3", "Category 1", 7.89, 1);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 4", "Category 2", 0.12, 0);
INSERT INTO hotel (name, category, price, available) VALUES ("Hotel 5", "Category 3", 3.45, 0);
