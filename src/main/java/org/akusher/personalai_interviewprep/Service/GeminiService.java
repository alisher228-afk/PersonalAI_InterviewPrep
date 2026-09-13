package org.akusher.personalai_interviewprep.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import org.akusher.personalai_interviewprep.Entity.Dto.Answers.AiEvaluationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private final Client geminiClient;
    private final ObjectMapper objectMapper;
    private static final String MODEL_NAME = "gemini-3.6-flash";
    public static final Logger log = LoggerFactory.getLogger(GeminiService.class);


    public GeminiService(Client geminiClient, ObjectMapper objectMapper) {
        this.geminiClient = geminiClient;
        this.objectMapper = objectMapper;
    }

    public AiEvaluationResult evaluateAnswer(String question, String expectedAnswer, String candidateAnswer) {
        String prompt = String.format("""
            Ты строгий технический интервьюер по Java / Backend.
            Вопрос собеседования: %s
            Ожидаемый ответ: %s
            Ответ кандидата: %s
            
            Оцени ответ кандидата по шкале от 1 до 10 и дай подробный фидбек на русском языке.
            
            ВЕРНИ ОТВЕТ СТРОГО В ВИДЕ JSON:
            {
              "score": <число от 1 до 10>,
              "feedback": "<текст разбора и рекомендаций>"
            }
            """, question, expectedAnswer != null ? expectedAnswer : "Не указан", candidateAnswer);

        try {
            GenerateContentConfig config = GenerateContentConfig.builder()
                    .responseMimeType("application/json")
                    .build();

            GenerateContentResponse response = geminiClient.models.generateContent(
                    MODEL_NAME,
                    prompt,
                    config
            );

            return objectMapper.readValue(response.text(), AiEvaluationResult.class);

        } catch (Exception e) {
            log.error("Ошибка AI оценки: {}", e.getMessage(), e);
            throw new RuntimeException("Не удалось получить оценку от AI: " + e.getMessage());
        }
    }
}