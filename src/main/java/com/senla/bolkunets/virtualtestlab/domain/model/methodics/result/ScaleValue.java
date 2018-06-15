package com.senla.bolkunets.virtualtestlab.domain.model.methodics.result;


import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.MethodicsKey;

import javax.persistence.*;

@Entity
@Table(name = "SCALE_VALUES")
public class ScaleValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "VALUE")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "METHODICS_KEY_ID")
    private MethodicsKey methodicsKey;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public MethodicsKey getMethodicsKey() {
        return methodicsKey;
    }

    public void setMethodicsKey(MethodicsKey methodicsKey) {
        this.methodicsKey = methodicsKey;
    }
}
