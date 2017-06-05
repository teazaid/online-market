package com.online.market.http.validation;

import java.util.Date;

/**
 * Created by Alexander on 04.06.2017.
 */
public class AgeValidator implements Validator<Date> {
    public Date validate(Date birthday) {
        // TODO person should be 18 years old
        return null;
    }
}
