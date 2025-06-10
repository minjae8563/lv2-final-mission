package finalmission.globar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ResetClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://randommer.io/api/Name?nameType=fullname&quantity=1\" -H \"accept: */*\" -H \"X-Api-Key: 59b351eda5d24b6c84e80c9130833a20")
                .build();
    }
}
