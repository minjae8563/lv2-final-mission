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
    private final RandomNameRestClient randomNameRestClient;

    public CustomerService(CustomerJpaRepository customerJpaRepository,
                           RandomNameRestClient randomNameRestClient) {
        this.customerJpaRepository = customerJpaRepository;
        this.randomNameRestClient = randomNameRestClient;
    }

    public Customer save(@Valid CustomerCreateRequest memberCreateResponse) {
        String name = memberCreateResponse.name();
        String email = memberCreateResponse.email();
        String password = memberCreateResponse.password();
        String nickName = randomNameRestClient.getRandomName();
        Customer customer = new Customer(name, nickName, email, password);
        return customerJpaRepository.save(customer);
    }
}
