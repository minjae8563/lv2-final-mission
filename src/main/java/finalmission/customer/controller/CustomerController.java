package finalmission.customer.controller;

import finalmission.customer.controller.dto.CustomerCreateRequest;
import finalmission.customer.entity.Customer;
import finalmission.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Customer> create(
            @Valid CustomerCreateRequest customerCreateRequest
    ) {
        Customer save = customerService.save(customerCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

}
