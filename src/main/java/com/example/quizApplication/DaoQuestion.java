package com.example.quizApplication;

import java.util.List;
import java.util.Objects;


public abstract class DaoQuestion implements QuestionRepository {
    private QuestionRepository questionRepository;
    @Override
    public Question saveQuestion(Question question) {
        return  questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question, Long questionId) {
        Question questionDB = questionRepository.findById(questionId).get();
        if (Objects.nonNull(question.getTopic()) && !"".equalsIgnoreCase(question.getTopic())) {
            questionDB.setQuestionContent(question.getTopic());
        }
        if (Objects.nonNull(question.getQuestionContent()) && !"".equalsIgnoreCase(question.getQuestionContent())) {
            questionDB.setQuestionContent(question.getQuestionContent());
        }
        if (Objects.nonNull(question.getDifficultyRankNumber()) && !"".equalsIgnoreCase(question.getDifficultyRankNumber())) {
            questionDB.setQuestionContent(question.getDifficultyRankNumber());
        }
        if (Objects.nonNull(question.getListResponse()) && !"".equalsIgnoreCase(question.getListResponse().toString())) {
            questionDB.setQuestionContent(question.getListResponse().toString());
        }
        return questionRepository.save(questionDB);

    }

    @Override
    public void deleteQuestionById(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public List<Question> findByTopic(String topic) {
        Question questionDB = (Question) questionRepository.findByTopic(topic);
        return (List<Question>) questionDB;
    }
}

