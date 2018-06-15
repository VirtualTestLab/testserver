package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;

public interface PersonService {
    Person create(Person person);

    Person update(Person person);

    void delete(Person person);

    Person getPersonInformation(Integer id);

    Person getFullPersonInformation(Integer id);
}
