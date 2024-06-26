package codoacodo.bookapi.configuration;

import codoacodo.bookapi.models.Dolar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BookConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);
    }
}
