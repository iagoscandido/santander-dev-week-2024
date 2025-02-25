package com.iagoscandido.sdw24;

import com.iagoscandido.sdw24.application.AskChampionUseCase;
import com.iagoscandido.sdw24.application.ListChampionsUseCase;
import com.iagoscandido.sdw24.domain.ports.ChampionsRepository;
import com.iagoscandido.sdw24.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository) {
        return new ListChampionsUseCase(repository);
    }
    @Bean
    public AskChampionUseCase provideAskChampionUseCase(ChampionsRepository repository, GenerativeAiService generativeAiService) {
        return new AskChampionUseCase(repository, generativeAiService);
    }

}
