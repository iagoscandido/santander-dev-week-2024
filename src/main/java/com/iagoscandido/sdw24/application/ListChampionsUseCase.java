package com.iagoscandido.sdw24.application;

import com.iagoscandido.sdw24.domain.model.Champion;
import com.iagoscandido.sdw24.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository repository) {
    public List<Champion> findAll() {
        return repository.findAll();
    }

}
