package com.travelagency.flight.model.service;

import com.travelagency.flight.model.service.schema.BookingConfirmationEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingConfirmationSenderImpl implements BookingConfirmationSender {

    @Value("${app.kafka.producer.topics.flight}")
    private String confirmationTopic;

    @Autowired
    private KafkaTemplate<String, BookingConfirmationEventDTO> kafkaTemplate;

    @Override
    public void sendBookingConfirmationEvent(final BookingConfirmationEventDTO bookingConfirmationEvent) {
        this.kafkaTemplate.send(confirmationTopic, bookingConfirmationEvent);
    }

}
