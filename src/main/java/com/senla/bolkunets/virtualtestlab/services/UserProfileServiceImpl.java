package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileDao userProfileDao;

    public UserProfileServiceImpl(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    @Transactional
    public UserProfile createUserProfile(UserProfile userProfile) {
       return userProfileDao.create(userProfile);
    }

    @Transactional
    public void deleteUserProfile(UserProfile userProfile) {
        userProfileDao.delete(userProfile);
    }

    @Transactional
    public UserProfile findUserProfileByLogin(String login) {
        return userProfileDao.findUserByLogin(login);
    }

    @Transactional
    public List<UserProfile> getUsers() {
        return userProfileDao.readAll();
    }

    @Transactional
    public UserProfile deleteUserProfileById(Integer id) {
        return userProfileDao.deleteById(id);
    }

    @Transactional
    public UserProfile updateUserProfile(UserProfile userProfile) {
        return userProfileDao.update(userProfile);
    }

}
