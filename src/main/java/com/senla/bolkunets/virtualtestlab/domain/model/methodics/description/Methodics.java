package com.senla.bolkunets.virtualtestlab.domain.model.methodics.description;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "METHODICS")
public class Methodics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false, length = 1000)
    private String description;
    @Column(name = "L_BORDER", nullable = false)
    private Integer leftValueBorder;
    @Column(name = "R_BORDER", nullable = false)
    private Integer rightValueBorder;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "METHODICS_ID")
    @OrderBy(value = "number")
    private Set<Question> questions;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "METHODICS_ID")
    private List<MethodicsKey> keys;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "methodicsId", fetch = FetchType.LAZY)
    private List<PassingFact> passingFacts;

    public List<PassingFact> getPassingFacts() {
        return passingFacts;
    }

    public void setPassingFacts(List<PassingFact> passingFacts) {
        this.passingFacts = passingFacts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLeftValueBorder() {
        return leftValueBorder;
    }

    public void setLeftValueBorder(Integer leftValueBorder) {
        this.leftValueBorder = leftValueBorder;
    }

    public Integer getRightValueBorder() {
        return rightValueBorder;
    }

    public void setRightValueBorder(Integer rightValueBorder) {
        this.rightValueBorder = rightValueBorder;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public List<MethodicsKey> getKeys() {
        return keys;
    }

    public void setKeys(List<MethodicsKey> keys) {
        this.keys = keys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Methodics methodics = (Methodics) o;
        return Objects.equals(id, methodics.id) &&
                Objects.equals(name, methodics.name) &&
                Objects.equals(description, methodics.description) &&
                Objects.equals(leftValueBorder, methodics.leftValueBorder) &&
                Objects.equals(rightValueBorder, methodics.rightValueBorder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, leftValueBorder, rightValueBorder);
    }
}
