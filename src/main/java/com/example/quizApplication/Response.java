package com.example.quizApplication;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="response")
public class Response {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name="question_id", nullable = false)
    private Question question;
    @Column(nullable = false, length = 100)
    private List<String> listResponses;

}
