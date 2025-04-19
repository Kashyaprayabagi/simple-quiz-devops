package com.quizapp;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class QuizController {

    static List<Map<String, Object>> sampleQuestions = List.of(
        Map.of(
            "question", "What is the capital of France?",
            "options", List.of("Paris", "Berlin", "Rome", "Madrid"),
            "answer", "Paris"
        ),
        Map.of(
            "question", "What is 2 + 2?",
            "options", List.of("3", "4", "5", "22"),
            "answer", "4"
        ),
        Map.of(
            "question", "Which planet is known as the Red Planet?",
            "options", List.of("Earth", "Mars", "Jupiter", "Venus"),
            "answer", "Mars"
        )
    );

    @GetMapping("/questions")
    public List<Map<String, Object>> getQuestions() {
        // Return questions without answers
        List<Map<String, Object>> sanitized = new ArrayList<>();
        for (Map<String, Object> q : sampleQuestions) {
            sanitized.add(Map.of(
                "question", q.get("question"),
                "options", q.get("options")
            ));
        }
        return sanitized;
    }

    @PostMapping("/submit")
    public Map<String, Object> submitAnswers(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            String correct = (String) sampleQuestions.get(i).get("answer");
            if (correct.equalsIgnoreCase(answers.get(i))) {
                score++;
            }
        }
        return Map.of("score", score, "total", sampleQuestions.size());
    }

    @GetMapping("/results")
    public Map<String, Object> getResults() {
        return Map.of("message", "This can be connected to DB later");
    }
}
