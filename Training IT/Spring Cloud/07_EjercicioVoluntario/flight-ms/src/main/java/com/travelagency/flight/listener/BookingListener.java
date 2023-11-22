package com.travelagency.flight.listener;

import com.travelagency.flight.model.service.FlightService;
import com.travelagency.flight.model.service.schema.BookingEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookingListener {

    @Autowired
    private FlightService flightService;

    @KafkaListener(topics = "${app.kafka.consumer.topics.booking}")
    public void onBookingEvent(final BookingEventDTO bookingEvent) {
        this.flightService.bookSeats(bookingEvent);
    }

}
