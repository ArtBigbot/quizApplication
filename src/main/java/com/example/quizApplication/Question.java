package com.example.quizApplication;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    @Column(nullable = false, length = 100)
    private String topic;
    @Column(nullable = false, length = 100)
    private String questionContent;
    @Column(nullable = false, length = 100)
    private String difficultyRankNumber;
    @OneToMany (mappedBy = "question", cascade = CascadeType.ALL)
    private List<Question> listResponse;

    protected Question() {}

    public Question(int questionId, String topic, String questionContent, List<Question> listResponse) {
        this.questionId = questionId;
        this.topic = topic;
        this.questionContent = questionContent;
        this.listResponse = listResponse;
    }

    @Override
    public String toString() {
        return String.format(
                "Question[id=%d, topic='%s', questionContent='%s', listResponse='%s']",
                questionId, topic, questionContent, listResponse);

    }

    public int getId() {
        return questionId;
    }

    public void setId(int questionId) {
        this.questionId = questionId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<Question> getListResponse() {
        return listResponse;
    }

    public void setListResponse(List<Question> listResponse) {
        this.listResponse = listResponse;
    }

    public String getDifficultyRankNumber() {
        return difficultyRankNumber;
    }

    public void setDifficultyRankNumber(String difficultyRankNumber) {
        this.difficultyRankNumber = difficultyRankNumber;
    }
}
