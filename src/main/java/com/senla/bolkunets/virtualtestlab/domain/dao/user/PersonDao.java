package com.senla.bolkunets.virtualtestlab.domain.dao.user;

import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;

import java.util.List;

public interface PersonDao extends GenericDao<Integer, Person> {

    Person getPersonWithPassingFacts(Integer id);

    List<Person> getPeoplePassedMethodics(Integer idMethodics);

    List<Person> getPeoplePassedMethodics();
}
