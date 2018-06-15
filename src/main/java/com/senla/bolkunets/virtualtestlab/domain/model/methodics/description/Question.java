package com.senla.bolkunets.virtualtestlab.domain.model.methodics.description;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONS")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "QUESTION_NUMBER")
    private Integer number;

    @Column(name = "TEXT", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "KEY_ID")
    private MethodicsKey methodicsKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public MethodicsKey getMethodicsKey() {
        return methodicsKey;
    }

    public void setMethodicsKey(MethodicsKey methodicsKey) {
        this.methodicsKey = methodicsKey;
    }
}
