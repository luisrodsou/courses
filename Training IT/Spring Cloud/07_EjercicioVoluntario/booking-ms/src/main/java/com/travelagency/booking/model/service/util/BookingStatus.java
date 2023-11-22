package com.travelagency.booking.model.service.util;

import java.util.Arrays;

public enum BookingStatus {

    PENDING_FLIGHT((short) 1),

    ACCEPTED((short) 2),

    REJECTED((short) 3);

    private final Short id;

    BookingStatus(Short id) {
        this.id = id;
    }

    public static BookingStatus valueOf(final Short statusId) {
        return Arrays.stream(BookingStatus.values()).filter(status -> status.id.equals(statusId)).findAny().orElseThrow();
    }

    public Short getId() {
        return id;
    }

}
