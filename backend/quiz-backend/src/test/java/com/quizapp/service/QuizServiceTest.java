package com.quizapp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class QuizServiceTest {

    @Test
    public void testScoreCalculation() {
        Map<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "C");
        correctAnswers.put(3, "B");

        Map<Integer, String> userAnswers = new HashMap<>();
        userAnswers.put(1, "A");
        userAnswers.put(2, "C");
        userAnswers.put(3, "D");

        int score = 0;
        for (Map.Entry<Integer, String> entry : userAnswers.entrySet()) {
            if (correctAnswers.containsKey(entry.getKey()) &&
                correctAnswers.get(entry.getKey()).equalsIgnoreCase(entry.getValue())) {
                score++;
            }
        }

        assertEquals(2, score);
    }
}

