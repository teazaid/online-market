package com.online.market.http.validation;

import com.online.market.http.model.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Alexander on 04.06.2017.
 */
@Service
public class RegistrationValidatorImpl implements Validator<CreateUserRequest> {
    @Autowired
    @Qualifier("ageValidator")
    private Validator<Date> ageValidator;

    @Autowired
    @Qualifier("emailValidator")
    private Validator<String> emailValidator;

    @Autowired
    @Qualifier("passwordValidator")
    private Validator<String> passwordValidator;

    @Autowired
    @Qualifier("loginValidator")
    private Validator<String> loginValidator;

    public CreateUserRequest validate(CreateUserRequest user) {
        // TODO validate user
        throw new UnsupportedOperationException("Implement validation");
    }
}
