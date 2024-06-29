package com.julionborges;

public record Question(String question, String correctAnswer, String incorrectAnswer1, String incorrectAnswer2, String incorrectAnswer3) {

    public Question {
        if (question == null || correctAnswer == null || incorrectAnswer1 == null || incorrectAnswer2 == null || incorrectAnswer3 == null) {
            throw new IllegalArgumentException("All fields must be non-null");
        }
    }

}
