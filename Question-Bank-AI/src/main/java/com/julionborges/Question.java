package com.julionborges;

public record Question(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {

    public Question {
        if (question == null || correctAnswer == null || wrongAnswer1 == null || wrongAnswer2 == null || wrongAnswer3 == null) {
            throw new IllegalArgumentException("All fields must be non-null");
        }
    }

}
