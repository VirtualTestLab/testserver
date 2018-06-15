package com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile;

import com.senla.bolkunets.virtualtestlab.domain.model.userprofile.RoleUser;

public class UserProfileDto {

    private Integer id;
    private String login;
    private String password;
    private RoleUser roleUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }
}
