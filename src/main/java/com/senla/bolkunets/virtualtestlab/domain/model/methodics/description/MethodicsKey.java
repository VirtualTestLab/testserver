package com.senla.bolkunets.virtualtestlab.domain.model.methodics.description;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "METHODICS_KEYS")
public class MethodicsKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SCALE_NAME", nullable = false)
    private String nameScale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameScale() {
        return nameScale;
    }

    public void setNameScale(String nameScale) {
        this.nameScale = nameScale;
    }
}
