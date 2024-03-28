package com.iagoscandido.sdw24.application;

import com.iagoscandido.sdw24.domain.exception.ChampionNotFoundException;
import com.iagoscandido.sdw24.domain.model.Champion;
import com.iagoscandido.sdw24.domain.ports.ChampionsRepository;
import com.iagoscandido.sdw24.domain.ports.GenerativeAiService;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiService generativeAiService) {
    public String askChampion(Long championId, String question) {
        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                    Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
                    Responda perguntas incorporando a personalidade e estilo de um determinado campeão.
                    Segue a pergunta, o nome do Campeão e sua respectiva lore (História):
                     
                """;
        return generativeAiService.generateContent(objective, context);



    }

}
