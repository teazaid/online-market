package com.online.market.http.validation;

/**
 * Created by Alexander on 04.06.2017.
 */
public class LoginValidator implements Validator<String>{
    public String validate(String login) {
        // TODO there should be only one user that contains such login
        return null;
    }
}
