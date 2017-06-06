package com.online.market.http.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.online.market.model.User;

import java.util.List;

/**
 * Created by Alexander on 06.06.2017.
 */
@JsonAutoDetect
public class UsersResponse {
    @JsonProperty
    private List<User> users;

    public UsersResponse(List<User> users) {
        this.users = users;
    }
}
