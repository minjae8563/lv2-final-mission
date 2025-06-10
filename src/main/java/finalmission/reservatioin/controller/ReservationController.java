package finalmission.reservatioin.controller;

import finalmission.customer.entity.Customer;
import finalmission.customer.resolver.LoginCustomer;
import finalmission.reservatioin.controller.dto.CurrentStateReservationResponse;
import finalmission.reservatioin.controller.dto.ReservationCreateRequest;
import finalmission.reservatioin.entity.Reservation;
import finalmission.reservatioin.service.ReservationService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> save(
        ReservationCreateRequest request
    ) {
        Reservation save = reservationService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mine")
    public ResponseEntity<List<Reservation>> getMyReservations(
            @LoginCustomer Customer customer
    ) {
        List<Reservation> findAll = reservationService.findAllByMemberId(customer.getId());
        return ResponseEntity.ok().body(findAll);
    }

    @GetMapping
    public ResponseEntity<List<CurrentStateReservationResponse>> getCurrentStateOfReservation() {
        List<CurrentStateReservationResponse> all = reservationService.findAllReservationWithNumberOfPeople();
        return ResponseEntity.ok().body(all);
    }
}
