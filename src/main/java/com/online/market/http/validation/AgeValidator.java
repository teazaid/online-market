package com.online.market.http.validation;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexander on 04.06.2017.
 */
public class AgeValidator implements Validator<Date> {
    public Date validate(Date birthday) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String birthDay = dateFormat.format(birthday);
        String currentDate = dateFormat.format(new Date());

        String partsCurrentDate[] = currentDate.split("\\-");
        String partsBirthday[] = birthDay.split("\\-");

        if (!dateCompare(partsCurrentDate, partsBirthday)) throw new InvalidArgumentException();  // need help to choose a kind of exception =)
        else return birthday;

        // TODO person should be 18 years old
    }

    private boolean dateCompare(String currentDate[], String birthday[]) {
        if (yearCompare(currentDate[2], birthday[2]) > 18) return true;
        else if (yearCompare(currentDate[2], birthday[2]) < 18) return false;
        else if (monthCompare(currentDate[1], birthday[1]) > 0) return true;
        else if (monthCompare(currentDate[1], birthday[1]) < 0) return false;
        else return dayCompare(currentDate[0], birthday[0]) >= 0;
    }

    private int yearCompare(String currentYear, String birthdayYear) {
        return Integer.parseInt(currentYear) - Integer.parseInt(birthdayYear);
    }

    private int monthCompare(String currentMonth, String birthdayMonth) {
        return Integer.parseInt(currentMonth) - Integer.parseInt(birthdayMonth);
    }

    private int dayCompare(String currentday, String birthdayDay) {
        return Integer.parseInt(currentday) - Integer.parseInt(birthdayDay);
    }
}
