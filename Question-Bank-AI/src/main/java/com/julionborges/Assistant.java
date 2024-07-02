package com.julionborges;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface Assistant {

    String chat(String message);

    @SystemMessage("You are a math teacher")
    @UserMessage("""
            Your task is to create a math questions of the topic and language limited by ---
            
            Answer with a JSON document containing:
            - the 'question' key set to the question about the topic
            - the 'correctAnswer' key set to the correct answer for the question
            - the 'wrongAnswer1' key set to the first incorrect response
            - the 'wrongAnswer2' key set to the second incorrect response
            - the 'wrongAnswer3' key set to the third incorrect response
            
            All fields must have the maximum of 250 characters

            ---
            topic: {topic},
            language: {language}
            ---
            """)
    Question createMathQuestion(String topic, String language);

}
