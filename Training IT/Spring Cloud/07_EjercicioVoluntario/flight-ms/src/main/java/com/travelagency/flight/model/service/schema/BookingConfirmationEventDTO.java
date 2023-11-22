package com.travelagency.flight.model.service.schema;

import java.util.Objects;

public class BookingConfirmationEventDTO {

    private Integer bookingId;

    private Boolean confirmed;

    public BookingConfirmationEventDTO() {
        super();
    }

    public BookingConfirmationEventDTO(Integer bookingId, Boolean confirmed) {
        this.bookingId = bookingId;
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "HotelConfirmationEventDTO{" +
                "bookingId=" + bookingId +
                ", confirmed=" + confirmed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingConfirmationEventDTO that = (BookingConfirmationEventDTO) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(confirmed, that.confirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, confirmed);
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

}
