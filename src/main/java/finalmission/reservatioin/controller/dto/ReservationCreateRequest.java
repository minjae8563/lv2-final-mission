package finalmission.reservatioin.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationCreateRequest(
        String customerName,
        String omakaseStoreName,
        LocalDate reservationDate,
        LocalTime reservationTime
) {
}
