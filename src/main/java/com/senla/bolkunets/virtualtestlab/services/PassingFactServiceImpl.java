package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.PassingFactDao;
import com.senla.bolkunets.virtualtestlab.domain.dao.user.PersonDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import com.senla.bolkunets.virtualtestlab.domain.services.PassingFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Service
public class PassingFactServiceImpl implements PassingFactService {

    private PassingFactDao passingFactDao;

    private MethodicsDao methodicsDao;

    private PersonDao personDao;

    public PassingFactServiceImpl(PassingFactDao passingFactDao, MethodicsDao methodicsDao, PersonDao personDao) {
        this.passingFactDao = passingFactDao;
        this.methodicsDao = methodicsDao;
        this.personDao = personDao;
    }

    @Override
    public PassingFact createPassingFact(PassingFact passingFact) {
        return passingFactDao.create(passingFact);
    }

    @Override
    public PassingFact getPassingFactForUser(Integer methodicsId, Integer userId) {
        PassingFact passingFact = passingFactDao.findPassingMethodicsForUser(methodicsId, userId);
        if(passingFact!=null) {
            passingFact.getScaleValues().size();
        }
        return passingFact;
    }

    @Override
    public void deletePassingFact(PassingFact deleteFact) {
        passingFactDao.delete(deleteFact);
    }

    @Override
    public List<PassingFact> getPassingFactsByMethodics(Integer methodicsId) {
        Methodics methodics = methodicsDao.read(methodicsId);
        methodics.getPassingFacts().size();
        return methodics.getPassingFacts();
    }


    @Override
    public List<PassingFact> findPassingFactByMethodicsId(Integer methodicsId) {
        List<PassingFact> passingFacts = passingFactDao.findByMethodicsIdWithValues(methodicsId);
        passingFacts.size();
        return passingFacts;
    }

    @Override
    public List<Person> getPersonsPassedMethodics(Integer methodicsId){
       return personDao.getPeoplePassedMethodics(methodicsId);
    }

    @Override
    public List<Person> getAllPersonWithPassedMethodics() {
        return personDao.getPeoplePassedMethodics();
    }
}
