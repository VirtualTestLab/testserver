package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<PKey, Entity> implements GenericDao<PKey, Entity> {

    private Logger log = Logger.getLogger(AbstractDao.class);

    private Class<Entity> type;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public AbstractDao(Class<Entity> type) {
        this.type = type;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public Entity create(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Entity read(PKey id) {
        return entityManager.find(type, id);
    }

    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }

    public void delete(Entity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Entity> readAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Entity> query = criteriaBuilder.createQuery(type);
        Root<Entity> from = query.from(type);
        CriteriaQuery<Entity> selectAll = query.select(from);
        return entityManager.createQuery(selectAll).getResultList();
    }

}
