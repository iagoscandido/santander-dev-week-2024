package com.iagoscandido.sdw24.application;

import com.iagoscandido.sdw24.domain.model.Champion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class ListChampionUseCaseTest {
    @Autowired
    private ListChampionsUseCase listChampionsUseCase;


    @Test
    public void testListChampions() {
        List<Champion> champions = listChampionsUseCase.findAll();

        Assertions.assertEquals(12, champions.size());
    }

}
