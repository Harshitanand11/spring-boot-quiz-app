//package com.java_first1_app.myfirstapp.controller;
//
//import com.java_first1_app.myfirstapp.model.Question;
//import com.java_first1_app.myfirstapp.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.java_first1_app.myfirstapp.service.QuizService;
//
//@RestController
//@RequestMapping("/quiz")
//public class QuizController {
//    @Autowired
//    private QuizService quizService;
//
//    @PostMapping("/start")
//    public User startQuiz(@RequestParam String userName) {
//        return quizService.startNewQuiz(userName);
//    }
//
//    @GetMapping("/question")
//    public Question getQuestion() {
//        return quizService.getRandomQuestion();
//    }
//
//    @PostMapping("/submit")
//    public boolean submitAnswer(@RequestParam Long userId, @RequestParam Long questionId, @RequestParam String answer) {
//        return quizService.submitAnswer(userId, questionId, answer);
//    }
//
//    @GetMapping("/summary/{userId}")
//    public User getSummary(@PathVariable Long userId) {
//        return quizService.getQuizSummary(userId);
//    }
//}
package com.java_first1_app.myfirstapp.controller;
//
//
//import model.Question;
//import model.User;
//import service.QuizService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;


import com.java_first1_app.myfirstapp.model.Question;
import com.java_first1_app.myfirstapp.model.User;
import com.java_first1_app.myfirstapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    /**
     * Start a new quiz session for a user.
     * @param userName Name of the user.
     * @return User entity representing the quiz session.
     */
    @PostMapping("/start")
    public User startQuiz(@RequestParam String userName) {
        return quizService.startNewQuiz(userName);
    }

    /**
     * Get a random quiz question from the database.
     * @return A random Question object.
     */
    @GetMapping("/question")
    public Question getQuestion() {
        return quizService.getRandomQuestion();
    }

    /**
     * Submit an answer for a quiz question.
     * @param userId ID of the user submitting the answer.
     * @param questionId ID of the question.
     * @param answer The answer provided by the user.
     * @return Boolean indicating whether the answer was correct.
     */
    @PostMapping("/submit")
    public boolean submitAnswer(@RequestParam Long userId, @RequestParam Long questionId, @RequestParam String answer) {
        return quizService.submitAnswer(userId, questionId, answer);
    }

    /**
     * Get a summary of a user's quiz progress.
     * @param userId ID of the user.
     * @return User entity containing quiz statistics.
     */
    @GetMapping("/summary/{userId}")
    public User getSummary(@PathVariable Long userId) {
        return quizService.getQuizSummary(userId);
    }
    @GetMapping("/ping")
    public String ping() {
        return "API is working!";
    }
}
