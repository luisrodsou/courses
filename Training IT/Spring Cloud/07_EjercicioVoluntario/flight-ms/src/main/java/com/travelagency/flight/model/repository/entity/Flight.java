package com.travelagency.flight.model.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "flight")
@Entity
public class Flight implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "company")
    private String company;

    @Column(name = "flight_date")
    private LocalDateTime flightDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "available_seats")
    private Short availableSeats;

    public Flight() {
        super();
    }

    public Flight(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", flightDate=" + flightDate +
                ", price=" + price +
                ", availableSeats=" + availableSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(company, flight.company) && Objects.equals(flightDate, flight.flightDate) && Objects.equals(price, flight.price) && Objects.equals(availableSeats, flight.availableSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, flightDate, price, availableSeats);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDateTime flightDate) {
        this.flightDate = flightDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Short getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Short availableSeats) {
        this.availableSeats = availableSeats;
    }

}
