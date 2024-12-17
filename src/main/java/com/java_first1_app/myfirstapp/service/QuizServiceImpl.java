//package com.java_first1_app.myfirstapp.service;
//
//
//import com.java_first1_app.myfirstapp.model.Question;
//import com.java_first1_app.myfirstapp.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.java_first1_app.myfirstapp.repository.QuestionRepository;
//import com.java_first1_app.myfirstapp.repository.UserRepository;
//
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class QuizServiceImpl implements QuizService {
//
//    @Autowired
//    private QuestionRepository questionRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public User startNewQuiz(String userName) {
//        User user = new User();
//        user.setName(userName);
//        user.setTotalQuestions(0);
//        user.setCorrectAnswers(0);
//        user.setIncorrectAnswers(0);
//        return userRepository.save(user);
//    }
//
//    @Override
//    public Question getRandomQuestion() {
//        long count = questionRepository.count();
//        Random random = new Random();
//        long randomId = random.nextLong(1, count + 1);
//        return questionRepository.findById(randomId).orElseThrow();
//    }
//
//    @Override
//    public boolean submitAnswer(Long userId, Long questionId, String answer) {
//        Optional<User> userOpt = userRepository.findById(userId);
//        Optional<Question> questionOpt = questionRepository.findById(questionId);
//
//        if (userOpt.isPresent() && questionOpt.isPresent()) {
//            User user = userOpt.get();
//            Question question = questionOpt.get();
//
//            user.setTotalQuestions(user.getTotalQuestions() + 1);
//
//            if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
//                user.setCorrectAnswers(user.getCorrectAnswers() + 1);
//                userRepository.save(user);
//                return true;
//            } else {
//                user.setIncorrectAnswers(user.getIncorrectAnswers() + 1);
//                userRepository.save(user);
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public User getQuizSummary(Long userId) {
//        return userRepository.findById(userId).orElseThrow();
//    }
//}
//
package com.java_first1_app.myfirstapp.service;

import com.java_first1_app.myfirstapp.model.Question;
import com.java_first1_app.myfirstapp.model.User;
import com.java_first1_app.myfirstapp.repository.QuestionRepository;
import com.java_first1_app.myfirstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Start a new quiz session for a user.
     */
    @Override
    public User startNewQuiz(String userName) {
        User user = new User();
        user.setName(userName);
        user.setTotalQuestions(0);
        user.setCorrectAnswers(0);
        user.setIncorrectAnswers(0);

        return userRepository.save(user);
    }

    /**
     * Fetch a random question from the database.
     */
    @Override
    public Question getRandomQuestion() {
        long count = questionRepository.count();
        if (count == 0) return null;

        Random random = new Random();
        long randomId = random.nextLong(1, count + 1);

        return questionRepository.findById(randomId).orElse(null);
    }

    /**
     * Submit an answer to a quiz question and update the user's performance.
     */
    @Override
    public boolean submitAnswer(Long userId, Long questionId, String answer) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Question> questionOpt = questionRepository.findById(questionId);

        if (userOpt.isPresent() && questionOpt.isPresent()) {
            User user = userOpt.get();
            Question question = questionOpt.get();

            user.setTotalQuestions(user.getTotalQuestions() + 1);

            if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
                user.setCorrectAnswers(user.getCorrectAnswers() + 1);
                userRepository.save(user);
                return true;
            } else {
                user.setIncorrectAnswers(user.getIncorrectAnswers() + 1);
                userRepository.save(user);
            }
        }

        return false;
    }

    /**
     * Retrieve the summary of the user's quiz performance.
     */
    @Override
    public User getQuizSummary(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
