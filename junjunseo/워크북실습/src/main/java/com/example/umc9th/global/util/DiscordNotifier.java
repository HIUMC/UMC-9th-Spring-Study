package com.example.umc9th.global.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@Profile("dev")
public class DiscordNotifier {

    @Value("${discord.webhook-url}")
    private String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 디스코드에 에러 메시지를 전송합니다.
     *
     * @param content 보낼 메시지 내용
     */
    public void sendMessage(String content) {
        try {

            String safeContent = content
                    .replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n");

            String json = String.format("{\"content\": \"%s\"}", safeContent);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);

            restTemplate.postForEntity(webhookUrl, entity, String.class);
            log.info("Sent Discord notification successfully.");

        } catch (Exception e) {
            log.error("Failed to send Discord notification: {}", e.getMessage());
        }
    }
    @PostConstruct
    public void init() {
        log.info("🔗 Loaded Discord Webhook URL: {}", webhookUrl);
    }
}
