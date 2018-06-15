package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.PassingFactDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PassingFactDaoImpl extends AbstractDao<Integer, PassingFact> implements PassingFactDao {
    public PassingFactDaoImpl() {
        super(PassingFact.class);
    }

    @Override
    public List<PassingFact> findByMethodicsIdWithValues(Integer methodicsId) {
        EntityManager entityManager = super.getEntityManager();
        return entityManager.createQuery("select facts from PassingFact facts where facts.methodicsId=:id")
                                                    .setParameter("id", methodicsId).getResultList();
    }

    @Override
    public List<PassingFact> findPassingMethodicsByUserId(Integer userId) {
        EntityManager entityManager = super.getEntityManager();
        return entityManager.createQuery("select facts from PassingFact facts where facts.personId=:id")
                .setParameter("id", userId).getResultList();
    }

    @Override
    public PassingFact findPassingMethodicsForUser(Integer methodicsId, Integer userId) {
        EntityManager entityManager = super.getEntityManager();
        return (PassingFact) entityManager.createQuery("select facts from PassingFact facts where facts.personId=:pid and facts.methodicsId=:mid")
                .setParameter("pid", userId).setParameter("mid", methodicsId).getResultList().get(0);
    }
}
