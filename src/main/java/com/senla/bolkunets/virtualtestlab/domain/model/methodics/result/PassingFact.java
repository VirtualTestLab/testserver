package com.senla.bolkunets.virtualtestlab.domain.model.methodics.result;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PASSING_FACT")
public class PassingFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date passingDate;

    @Column(name = "PEOPLE_ID", nullable = false)
    private Integer personId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PASSING_FACT_ID")
    private List<ScaleValue> scaleValues;

    @Column(name="METHODICS_ID")
    private Integer methodicsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPassingDate() {
        return passingDate;
    }

    public void setPassingDate(Date passingDate) {
        this.passingDate = passingDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public List<ScaleValue> getScaleValues() {
        return scaleValues;
    }

    public void setScaleValues(List<ScaleValue> scaleValues) {
        this.scaleValues = scaleValues;
    }

    public Integer getMethodicsId() {
        return methodicsId;
    }

    public void setMethodicsId(Integer methodicsId) {
        this.methodicsId = methodicsId;
    }
}
