package com.mobily.elite.appUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringExpression {

    public static boolean isEmailValid(String email){
        String regExp =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    public static boolean isTextValid(String text){
        return text != null && !text.isEmpty() && !text.trim().equals("");
    }

    public static boolean isPasswordValid(String password){
        /*String regExp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,19}$";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();*/
        return password.length() >= 6;
    }
}
