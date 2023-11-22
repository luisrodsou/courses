package com.travelagency.booking.model.service;

import com.travelagency.booking.model.service.schema.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class HotelClientImpl implements HotelClient {

    @Value("${app.rest.client.hotel-ms.url}")
    private String hotelServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Optional<HotelDTO> getHotelByName(final String name) {
        final URI uri = UriComponentsBuilder.fromUriString(this.hotelServiceUrl)
                .path("hotel").queryParam("name", name).build().toUri();

        return Optional.ofNullable(this.restTemplate.getForObject(uri, HotelDTO.class));
    }

    @Override
    public Optional<HotelDTO> getHotelById(final Integer id) {
        final URI uri = UriComponentsBuilder.fromUriString(this.hotelServiceUrl)
                .pathSegment("hotel", "{id}").build(id);

        return Optional.ofNullable(this.restTemplate.getForObject(uri, HotelDTO.class));
    }

}
