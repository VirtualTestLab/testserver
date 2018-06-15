package com.senla.bolkunets.virtualtestlab.security.services.impl;

import com.senla.bolkunets.virtualtestlab.domain.dao.user.UserProfileDao;
import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.UserProfile;
import com.senla.bolkunets.virtualtestlab.security.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserProfileDao userProfileDao;

    public UserDetailServiceImpl(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserProfile userProfile = userProfileDao.findUserByLogin(username);
        if(userProfile == null){
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }

        return new User(userProfile);

    }
}
