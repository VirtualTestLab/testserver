package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.ScaleValue;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;

import java.util.List;

public interface PassingFactService {

    PassingFact createPassingFact(PassingFact passingFact);

    PassingFact getPassingFactForUser(Integer methodicsId, Integer userId);

    void deletePassingFact(PassingFact deleteFact);

    List<PassingFact> getPassingFactsByMethodics(Integer methodicsId);

    List<PassingFact> findPassingFactByMethodicsId(Integer methodicsId);

    List<Person> getPersonsPassedMethodics(Integer methodicsId);

    List<Person> getAllPersonWithPassedMethodics();
}
