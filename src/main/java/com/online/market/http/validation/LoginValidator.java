package com.online.market.http.validation;

import com.online.market.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alexander on 04.06.2017.
 */
public class LoginValidator implements Validator<String>{
    @Autowired
    private UserRepository userRepository;

    public String validate(String login) {
        // TODO there should be only one user that contains such login
        return null;
    }
}
