// ChatGPTService.java
package com.tools.demo.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ChatGPTService {

    private static final Logger logger = LoggerFactory.getLogger(ChatGPTService.class);

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "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"; // 确保这里是您的 OpenAI API 密钥
    private final String apiUrl = "https://api.openai.com/v1/chat/completions";
    
    public String getResponseFromChatGPT(String prompt) {
        logger.info("Sending request to ChatGPT with prompt: {}", prompt);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(apiKey);

        // 使用标准的字符串连接构建请求体
        String requestBody = String.format(
            "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}",
            prompt.replace("\"", "\\\"") // 转义引号
        );

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    String.class
            );
            // 记录接收到的响应
            logger.info("Received response from ChatGPT: {}", response.getBody());
            return response.getBody();
        } catch (Exception e) {
            // 记录错误级别的日志
            logger.error("Error while communicating with ChatGPT: {}", e.getMessage(), e);
            return "Error: " + e.getMessage();
        }
    }

}
