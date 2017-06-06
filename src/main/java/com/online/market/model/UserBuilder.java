package com.online.market.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Alexander on 04.06.2017.
 */
public class UserBuilder implements Builder<User> {

    private User user;

    public UserBuilder() {
        user = new User();
    }

    public User build() {
        return user;
    }

    public UserBuilder login(String login) {
        user.setLogin(login);
        return this;
    }

    public UserBuilder id(long id) {
        user.setId(id);
        return this;
    }

    public UserBuilder uuid(String uuid) {
        user.setUuid(uuid);
        return this;
    }

    public UserBuilder firstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder lastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder passwordHash(String pswdHash) {
        user.setPasswordHash(pswdHash);
        return this;
    }

    public UserBuilder email(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder birthday(Date birthday) {
        user.setBirthday(birthday);
        return this;
    }

    public UserBuilder country(String country) {
        user.setCountry(country);
        return this;
    }

    public UserBuilder phoneNumber(String phoneNuber) {
        user.setPhoneNumber(phoneNuber);
        return this;
    }

    public UserBuilder generateUuid() {
        user.setUuid(UUID.randomUUID().toString());
        return this;
    }

}
