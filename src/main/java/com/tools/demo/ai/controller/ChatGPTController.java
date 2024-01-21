package com.tools.demo.ai.controller;

import org.springframework.web.bind.annotation.*;
import com.tools.demo.ai.service.ChatGPTService;
import com.tools.demo.ai.dto.ChatGPTRequest;

@RestController
@RequestMapping("/api/chatgpt")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/ask")
    public String askChatGPT(@RequestBody ChatGPTRequest request) {
        return chatGPTService.getResponseFromChatGPT(request.getPrompt());
    }
}