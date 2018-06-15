package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.methodics.MethodicsDao;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MethodicsDaoImpl extends AbstractDao<Integer, Methodics> implements MethodicsDao {
    public MethodicsDaoImpl() {
        super(Methodics.class);
    }

    @Override
    public Methodics getMethodicsByName(String name) {
        Methodics methodics = null;
        EntityManager entityManager = super.getEntityManager();
        methodics = (Methodics) entityManager
                .createQuery("select methodics from Methodics methodics where methodics.name = :name")
                .setParameter("name", name).getResultList().get(0);
        return methodics;
    }

    @Override
    public Methodics getMethodicsWithQuastions(Integer id){
        Methodics methodics = super.read(id);
        if(methodics!=null){
            methodics.getQuestions().size();
        }
        return methodics;
    }

    @Override
    public void deleteById(Integer id) {
        Methodics methodics = super.read(id);
        methodics.getQuestions().clear();
        methodics.getKeys().clear();
        super.delete(methodics);
    }

    @Override
    public Methodics readFullMethodics(Integer id){
        Methodics methodics = getMethodicsWithQuastions(id);
        if(methodics!=null){
            methodics.getKeys().size();
        }
        return methodics;
    }
}
