package com.java_first1_app.myfirstapp.repository;



import com.java_first1_app.myfirstapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
