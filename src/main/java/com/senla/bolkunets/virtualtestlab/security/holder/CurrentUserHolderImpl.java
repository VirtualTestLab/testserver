package com.senla.bolkunets.virtualtestlab.security.holder;

import com.senla.bolkunets.virtualtestlab.security.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUserHolderImpl implements CurrentUserHolder {
    @Override
    public User getCurrentUser() {
        return  (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
