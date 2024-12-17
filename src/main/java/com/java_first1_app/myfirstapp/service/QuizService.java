//package com.java_first1_app.myfirstapp.service;
////package com.yourname.quizapp.service;
//
////import com.yourname.quizapp.model.Question;
////import com.yourname.quizapp.model.User;
//import com.java_first1_app.myfirstapp.model.Question;
//import com.java_first1_app.myfirstapp.model.User;
//
//public interface QuizService {
//    User startNewQuiz(String userName);
//    Question getRandomQuestion();
//    boolean submitAnswer(Long userId, Long questionId, String answer);
//    User getQuizSummary(Long userId);
//}
//
package com.java_first1_app.myfirstapp.service;

import com.java_first1_app.myfirstapp.model.Question;
import com.java_first1_app.myfirstapp.model.User;

public interface QuizService {
    User startNewQuiz(String userName);
    Question getRandomQuestion();
    boolean submitAnswer(Long userId, Long questionId, String answer);
    User getQuizSummary(Long userId);
}
