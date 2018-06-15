package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.PersonDao;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import com.senla.bolkunets.virtualtestlab.domain.services.PersonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person create(Person person){
        return personDao.create(person);
    }

    @Override
    public Person update(Person person){
        return personDao.update(person);
    }

    @Override
    public void delete(Person person){
        personDao.delete(person);
    }

    @Override
    public Person getPersonInformation(Integer id){
        return personDao.read(id);
    }

    @Override
    public Person getFullPersonInformation(Integer id){
        return personDao.getPersonWithPassingFacts(id);
    }

}
