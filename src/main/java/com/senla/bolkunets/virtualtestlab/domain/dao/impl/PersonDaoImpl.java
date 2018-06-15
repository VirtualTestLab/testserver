package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.PersonDao;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {
    public PersonDaoImpl() {
        super(Person.class);
    }

    @Override
    public Person getPersonWithPassingFacts(Integer id) {
        EntityManager entityManager = super.getEntityManager();
        Person person = (Person) entityManager.createQuery("select person from Person person where person.id = :id")
                .setParameter("id", id).getResultList().get(0);
        person.getPassingFacts().size();

        return person;
    }

    @Override
    public List<Person> getPeoplePassedMethodics(Integer idMethodics) {
        EntityManager entityManager = super.getEntityManager();
        List<Person> people = entityManager.createQuery("select distinct person from Person person join fetch PassingFact fact on fact.personId = person.id where fact.methodicsId=:id")
                .setParameter("id", idMethodics).getResultList();
        people.forEach(person -> person.getPassingFacts().size());

        return people;
    }

    @Override
    public List<Person> getPeoplePassedMethodics() {
        EntityManager entityManager = super.getEntityManager();
        List<Person> people = entityManager.createQuery("select distinct person from PassingFact fact left join Person person on fact.personId = person.id ").getResultList();
        people.forEach(person -> person.getPassingFacts().size());

        return people;
    }
}
