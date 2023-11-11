DROP DATABASE IF EXISTS courses;
CREATE DATABASE courses;
USE courses;

CREATE TABLE course (
  course_code VARCHAR(10) PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  duration INT NOT NULL,
  price DOUBLE NOT NULL
);

INSERT INTO course VALUES ("C01", "Java", 1, 10.1);
INSERT INTO course VALUES ("C02", "Spring Boot", 2, 20.25);
INSERT INTO course VALUES ("C03", "Spring Web", 3, 30.3);
INSERT INTO course VALUES ("C04", "Spring JPA", 4, 40.45);
INSERT INTO course VALUES ("C05", "MySQL", 5, 50);
