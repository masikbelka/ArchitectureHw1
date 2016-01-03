package com.epam.cdp.architecture.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType=DiscriminatorType.STRING
)
public class User {

    @Id
    @NotEmpty
    private String username;

    @NotNull
    private String name;

    @NotNull
    private Date dateOfBirth;

    @ManyToOne(cascade={CascadeType.ALL}, optional = true)
    private User user;

    @OneToMany
    private Set<User> friends = new HashSet<>();


    public User() {
    }

    public User(String username, String name, Date dateOfBirth) {
        this.username = username;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
