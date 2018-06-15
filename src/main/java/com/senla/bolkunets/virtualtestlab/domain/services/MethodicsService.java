package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;

import java.util.List;

public interface MethodicsService {

    Methodics createMethodics(Methodics methodics);

    Methodics updateMethodics(Methodics methodics);

    void deleteMethodics(Methodics methodics);

    List<Methodics> getAllMethodics();

    Methodics findById(Integer id);

    List<Methodics> getAssignedMethodicsByUserProfile(Integer userProfileId);

    List<Methodics> getPassedMethodicsByUserProfile(Integer userProfileId);

    List<Methodics> getNoPassedMethodicsByUserProfile(Integer userProfileId);

    void deleteMethodicsById(Integer id);

    Methodics getMethodicsWithQuestions(Integer id);

    Methodics getFullMethodics(Integer id);

}
