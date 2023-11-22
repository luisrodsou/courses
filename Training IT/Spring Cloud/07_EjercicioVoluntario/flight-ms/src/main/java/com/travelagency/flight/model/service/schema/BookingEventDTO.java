package com.travelagency.flight.model.service.schema;

import java.io.Serializable;
import java.util.Objects;

public class BookingEventDTO implements Serializable {

    private Integer bookingId;

    private Integer flightId;

    private Short seats;

    @Override
    public String toString() {
        return "BookingEventDTO{" +
                "bookingId=" + bookingId +
                ", flightId=" + flightId +
                ", seats=" + seats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEventDTO that = (BookingEventDTO) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(flightId, that.flightId) && Objects.equals(seats, that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, flightId, seats);
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Short getSeats() {
        return seats;
    }

    public void setSeats(Short seats) {
        this.seats = seats;
    }

}
