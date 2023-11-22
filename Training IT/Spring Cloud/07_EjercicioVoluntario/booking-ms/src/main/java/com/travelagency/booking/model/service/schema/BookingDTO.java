package com.travelagency.booking.model.service.schema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Objects;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.WRITE_ONLY;

@Schema(description = "Datos de una reserva")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDTO implements Serializable {

    @Schema(description = "Nombre del cliente")
    private String name;

    @Schema(description = "DNI del cliente")
    private String dni;

    @Schema(description = "Número de personas", accessMode = WRITE_ONLY)
    private Short peopleCount;

    @Schema(description = "Identificador del vuelo")
    private Integer flightId;

    @Schema(description = "Identificador del hotel", accessMode = WRITE_ONLY)
    private Integer hotelId;

    public BookingDTO() {
        super();
    }

    public BookingDTO(final String name, final String dni, final Integer flightId) {
        this.name = name;
        this.dni = dni;
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", peopleCount=" + peopleCount +
                ", flightId=" + flightId +
                ", hotelId=" + hotelId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDTO that = (BookingDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(dni, that.dni) && Objects.equals(peopleCount, that.peopleCount) && Objects.equals(flightId, that.flightId) && Objects.equals(hotelId, that.hotelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dni, peopleCount, flightId, hotelId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Short getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Short peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

}
