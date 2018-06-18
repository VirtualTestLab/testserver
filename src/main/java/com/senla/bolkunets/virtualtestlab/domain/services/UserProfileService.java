package com.senla.bolkunets.virtualtestlab.domain.services;

import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile createUserProfile(UserProfile userProfile);

    UserProfile findUserProfileByLogin(String login);
    List<UserProfile> getUsers();

    UserProfile deleteUserProfileById(Integer id);

    UserProfile updateUserProfile(UserProfile userProfile);

    UserProfile findUserProfileById(Integer idUser);
}