package com.senla.bolkunets.virtualtestlab.domain.model.userprofile;

import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROFILES_USER")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleUser roleUser;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Methodics> openMethodicsForUser;

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

    public List<Methodics> getOpenMethodicsForUser() {
        return openMethodicsForUser;
    }

    public void setOpenMethodicsForUser(List<Methodics> openMethodicsForUser) {
        this.openMethodicsForUser = openMethodicsForUser;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
