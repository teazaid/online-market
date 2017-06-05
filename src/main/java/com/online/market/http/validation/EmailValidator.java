package com.online.market.http.validation;

import com.online.market.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alexander on 04.06.2017.
 */
public class EmailValidator implements Validator<String>{
    @Autowired
    private UserRepository userRepository;

    public String validate(String email) {
        // TODO validate that email is unique and that is looks like partOne@partTwo.partThree
        // https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository
        return null;
    }
}
