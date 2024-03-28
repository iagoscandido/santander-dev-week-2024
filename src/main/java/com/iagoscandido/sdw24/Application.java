package com.iagoscandido.sdw24;

import com.iagoscandido.sdw24.domain.application.ListChampionsUseCase;
import com.iagoscandido.sdw24.domain.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    public ListChampionsUseCase listChampionsUseCase(ChampionsRepository repository) {
        return new ListChampionsUseCase(repository);
    }

}
