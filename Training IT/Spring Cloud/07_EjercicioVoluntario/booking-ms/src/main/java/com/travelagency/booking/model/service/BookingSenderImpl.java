package com.travelagency.booking.model.service;

import com.travelagency.booking.model.service.schema.BookingEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingSenderImpl implements BookingSender {

    @Value("${app.kafka.producer.topics.booking}")
    private String bookingTopic;

    @Autowired
    private KafkaTemplate<String, BookingEventDTO> kafkaTemplate;

    @Override
    public void sendBookingEvent(BookingEventDTO bookingEvent) {
        this.kafkaTemplate.send(bookingTopic, bookingEvent);
    }

}
