//WISSEBO ABDULMAJID 2218587
package com.airlinereservation;

import java.time.LocalDateTime;

public class Cancellation {
    private Booking booking;
    private String reason;
    private LocalDateTime cancellationDateTime;

    public Cancellation(Booking booking, String reason) {
        this.booking = booking;
        this.reason = reason;
        this.cancellationDateTime = LocalDateTime.now();
    }

    public Booking getBooking() {
        return booking;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getCancellationDateTime() {
        return cancellationDateTime;
    }

    public String getCancellationDateTimeFormatted() {
        // Format cancellationDateTime as a string in the desired format
        // For example: return cancellationDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return cancellationDateTime.toString();
    }

    // Other methods and properties specific to cancellations
}
