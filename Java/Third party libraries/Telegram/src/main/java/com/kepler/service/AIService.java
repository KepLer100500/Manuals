package com.kepler.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AIService {
    @Value("${api.url}")
    private String API_URL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public String process(String request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // Формируем JSON-платейлоад
        ObjectNode messageSystem = mapper.createObjectNode();
        messageSystem.put("role", "system");
        messageSystem.put("content", "You are a smart assistant");

        ObjectNode messageUser = mapper.createObjectNode();
        messageUser.put("role", "user");
        messageUser.put("content", request);

        ObjectNode payload = mapper.createObjectNode();
        payload.put("model", "llama-3.3-70b-instruct");
        payload.set("messages", mapper.createArrayNode().add(messageSystem).add(messageUser));
        payload.put("max_tokens", 500);
        payload.put("preference", "balanced");

        // Заголовки
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(payload), headers);

        // Отправка POST-запроса
        ResponseEntity<String> response = restTemplate.exchange(
                API_URL,
                HttpMethod.POST,
                entity,
                String.class
        );

        // Парсим только content
        ObjectNode root = (ObjectNode) mapper.readTree(response.getBody());
        String content = root
                .withArray("choices")
                .get(0)
                .get("message")
                .get("content")
                .asText();

        log.info("{} -> {}", request, content);

        return content;
    }
}
