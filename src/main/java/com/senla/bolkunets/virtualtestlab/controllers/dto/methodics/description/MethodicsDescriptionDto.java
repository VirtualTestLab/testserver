package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description;

public class MethodicsDescriptionDto {

    private Integer id;

    private String name;

    private String description;

    private Integer leftValueBorder;

    private Integer rightValueBorder;

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
}
