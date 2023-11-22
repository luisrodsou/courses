package com.travelagency.booking.listener;

import com.travelagency.booking.model.service.BookingService;
import com.travelagency.booking.model.service.schema.BookingConfirmationEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationListener {

    @Autowired
    private BookingService bookingService;

    @KafkaListener(topics = "${app.kafka.consumer.topics.flight}")
    public void onFlightConfirmationEvent(final BookingConfirmationEventDTO bookingConfirmationEvent) {
        this.bookingService.updateBookingStatus(bookingConfirmationEvent);
    }

}
