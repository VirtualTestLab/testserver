package com.senla.bolkunets.virtualtestlab.domain.dao.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {
    public UserProfileDaoImpl() {
        super(UserProfile.class);
    }

    public UserProfile findUserByLogin(String login) {
        UserProfile userProfile = null;
        EntityManager entityManager = super.getEntityManager();
        userProfile = (UserProfile) entityManager
                .createQuery("select user from UserProfile user where user.login = :login ")
                .setParameter("login", login).getSingleResult();
        return userProfile;
    }

    @Override
    public UserProfile deleteById(Integer id) {
        EntityManager entityManager = super.getEntityManager();
        entityManager.createQuery("delete from UserProfile user where user.id=:id")
                     .setParameter("id", id).executeUpdate();
        return null;
    }
}
