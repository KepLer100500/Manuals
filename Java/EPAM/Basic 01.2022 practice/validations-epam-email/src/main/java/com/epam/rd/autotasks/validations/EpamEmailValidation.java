package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-z]+_[a-z]+[0-9]*@epam.com");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
