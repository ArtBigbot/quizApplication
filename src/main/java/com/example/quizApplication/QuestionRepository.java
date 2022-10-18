package com.example.quizApplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
    public Question saveQuestion(Question question);
    public Question updateQuestion(Question question, Long questionId);
    public void deleteQuestionById (Long questionId);
    List<Question> findByTopic(String topic);

}
