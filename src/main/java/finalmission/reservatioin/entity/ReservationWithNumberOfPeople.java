package finalmission.reservatioin.entity;

import finalmission.customer.entity.Customer;
import finalmission.omakase.entity.Omakase;
import java.time.LocalDate;

public class ReservationWithNumberOfPeople {

    private final Reservation reservation;
    private final long rank;

    public ReservationWithNumberOfPeople(Reservation reservation, long rank) {
        this.reservation = reservation;
        this.rank = rank;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public long getRank() {
        return rank;
    }
}
