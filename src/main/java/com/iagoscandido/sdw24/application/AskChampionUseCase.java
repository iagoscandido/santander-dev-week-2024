package com.iagoscandido.sdw24.application;

import com.iagoscandido.sdw24.domain.exception.ChampionNotFoundException;
import com.iagoscandido.sdw24.domain.model.Champion;
import com.iagoscandido.sdw24.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {
    public String askChampion(Long championId, String question) {
        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        //TODO: Evoluir a logica de negocios para considerar a integração com AIs Generativas.
        return champion.generateContextByQuestion(question);


    }

}
