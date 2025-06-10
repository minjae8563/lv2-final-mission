package finalmission.customer.service;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RandomNameRestClient {

    private final RestClient restClient;

    public RandomNameRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public String getRandomName() {
        return restClient.get()
                .retrieve()
                .body(String.class);
    }
}
