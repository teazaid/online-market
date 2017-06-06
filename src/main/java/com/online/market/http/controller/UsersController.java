package com.online.market.http.controller;

import com.online.market.db.UserRepository;
import com.online.market.http.model.CreateUserRequest;
import com.online.market.http.model.UsersResponse;
import com.online.market.model.User;
import com.online.market.model.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alexander on 06.06.2017.
 */
@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/find",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UsersResponse find(@RequestParam("email") String email) {
        List<User> byEmail = userRepository.findByEmail(email);

        return new UsersResponse(byEmail);
    }
}
