package com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile;

import com.senla.bolkunets.virtualtestlab.domain.model.user.Gender;
import com.senla.bolkunets.virtualtestlab.domain.model.user.MaritalStatus;
import com.senla.bolkunets.virtualtestlab.domain.model.user.PlaceResidence;

public class PersonInformationDto {

    private Integer id;

    private Gender gender;

    private Integer age;

    private MaritalStatus maritalStatus;

    private Integer countChildren;

    private PlaceResidence placeResidence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getCountChildren() {
        return countChildren;
    }

    public void setCountChildren(Integer countChildren) {
        this.countChildren = countChildren;
    }

    public PlaceResidence getPlaceResidence() {
        return placeResidence;
    }

    public void setPlaceResidence(PlaceResidence placeResidence) {
        this.placeResidence = placeResidence;
    }
}
