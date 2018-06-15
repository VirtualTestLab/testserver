package com.senla.bolkunets.virtualtestlab.domain.dao.user;

import com.senla.bolkunets.virtualtestlab.domain.dao.GenericDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;

public interface UserProfileDao extends GenericDao<Integer, UserProfile> {
    UserProfile findUserByLogin(String login);

    UserProfile deleteById(Integer id);
}
