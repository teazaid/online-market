package com.online.market.http.controller;

import com.online.market.db.UserRepository;
import com.online.market.http.model.CreateUserRequest;
import com.online.market.http.validation.Validator;
import com.online.market.model.User;
import com.online.market.model.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alexander on 04.06.2017.
 */
@RestController
public class RegistrationController {
    @Autowired
    private Validator<CreateUserRequest> registrationValidator;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody CreateUserRequest createUserRequest) {
        registrationValidator.validate(createUserRequest);

        UserBuilder userBuilder = new UserBuilder();
        // TODO build user
        User user = userBuilder.build();

        userRepository.createUser(user);
        return "ok";
    }

    @RequestMapping(value = "/show",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateUserRequest register() {
        return new CreateUserRequest();
    }

    @RequestMapping("/")
    public String index() {
        return "registration form";
    }
}
