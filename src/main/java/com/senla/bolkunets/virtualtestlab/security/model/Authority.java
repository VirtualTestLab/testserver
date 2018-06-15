package com.senla.bolkunets.virtualtestlab.security.model;

import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.RoleUser;
import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private RoleUser roleUser;

    public Authority(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    @Override
    public String getAuthority() {
        return roleUser.name();
    }
}
