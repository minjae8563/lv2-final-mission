package finalmission.customer.service;

import finalmission.customer.controller.dto.CustomerCreateRequest;
import finalmission.customer.entity.Customer;
import finalmission.customer.repository.CustomerJpaRepository;
import finalmission.reservatioin.entity.Reservation;
import finalmission.reservatioin.respository.ReservationJpaRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerJpaRepository customerJpaRepository;
    private final ReservationJpaRepository reservationJpaRepository;

    public CustomerService(CustomerJpaRepository customerJpaRepository,
                           ReservationJpaRepository reservationJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
        this.reservationJpaRepository = reservationJpaRepository;
    }

    public Customer save(@Valid CustomerCreateRequest memberCreateResponse) {
        String name = memberCreateResponse.name();
        String email = memberCreateResponse.email();
        String password = memberCreateResponse.password();
        Customer customer = new Customer(name, email, password);
        return customerJpaRepository.save(customer);
    }

    public List<Reservation> findAllByMemberId(Long id) {
        return reservationJpaRepository.findAllByCustomerId(id);
    }
}
