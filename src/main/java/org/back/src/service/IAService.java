package org.back.src.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IAService {
    @Value("${openai.api.key}")
    private String openAiApiKey;

    private static final String OPENAI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=";

    public String transformarQuestao(String questao) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("contents", List.of(
                Map.of(
                        "parts", List.of(
                                Map.of("text",
                                        "Transforme a seguinte pergunta em uma curta e simples tarefa de RPG: " + questao)
                        )
                )
        ));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL + openAiApiKey, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }


}
