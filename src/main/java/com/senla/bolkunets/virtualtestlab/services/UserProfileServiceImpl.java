package com.senla.bolkunets.virtualtestlab.services;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.domain.services.UserProfileService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private UserProfileDao userProfileDao;

    public UserProfileServiceImpl(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
       return userProfileDao.create(userProfile);
    }

    public void deleteUserProfile(UserProfile userProfile) {
        userProfileDao.delete(userProfile);
    }

    public UserProfile findUserProfileByLogin(String login) {
        return userProfileDao.findUserByLogin(login);
    }

    public List<UserProfile> getUsers() {
        return userProfileDao.readAll();
    }

    public UserProfile deleteUserProfileById(Integer id) {
        return userProfileDao.deleteById(id);
    }

    public UserProfile updateUserProfile(UserProfile userProfile) {
        return userProfileDao.update(userProfile);
    }

    @Override
    public UserProfile findUserProfileById(Integer idUser) {
        return userProfileDao.read(idUser);
    }

}
