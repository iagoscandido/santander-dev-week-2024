package com.iagoscandido.sdw24.adapters.in;

import com.iagoscandido.sdw24.application.AskChampionUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Campeões", description = "Endpoint do domínio de Campeões do League of Legends")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {


    @PostMapping("/{championId}/ask")
    public askChampionResponse askChampion(
            @PathVariable(name = "championId") Long championId,
            @RequestBody askChampionRequest request
    ) {

        String answer = useCase.askChampion(championId, request.question());

        return new askChampionResponse(answer);
    }

    public record askChampionRequest(String question) {
    }

    public record askChampionResponse(String answer) {
    }
}
