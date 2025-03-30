package com.projects.health_fitness_planner;

import org.springframework.web.bind.annotation.RestController;
import spring.ai.openai.chat.options.*;

@RestController
public class HealthFitnessPlannerController
{
    @RequestMapping("/")
    @ResponseBody
    public String index()
    {
        return "index.html";
    }

    @PostMapping
    @ResponseBody
    public String generateResponse()
    {
        ChatResponse response = chatModel.call(
                new Prompt(
                        userGeneralDescBox.text,
                        OpenAiChatOptions.builder()
                                .model("gpt-4o-mini")
                                .temperature(0.4)
                                .build()
                ));
        return response.text;
    }
}
