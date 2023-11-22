package com.travelagency.booking.model.repository.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "booking")
@Entity
public class Booking implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "status_id")
    private Short statusId;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", dni='" + dni + '\'' +
                ", hotelId=" + hotelId +
                ", flightId=" + flightId +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(clientName, booking.clientName) && Objects.equals(dni, booking.dni) && Objects.equals(hotelId, booking.hotelId) && Objects.equals(flightId, booking.flightId) && Objects.equals(statusId, booking.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, dni, hotelId, flightId, statusId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }
    
}
