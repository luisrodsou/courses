package com.travelagency.booking.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FlightClientImpl implements FlightClient {

    @Value("${app.rest.client.flight-ms.url}")
    private String flightServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void bookSeats(Integer flightId, Short seats) {
        final URI uri = UriComponentsBuilder.fromUriString(this.flightServiceUrl)
                .pathSegment("flight", "{id}").queryParam("seats", seats).build(flightId);

        this.restTemplate.put(uri, null);
    }

}
