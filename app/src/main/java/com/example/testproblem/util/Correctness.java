package com.example.testproblem.util;

import android.widget.EditText;

import java.util.regex.Pattern;

public class Correctness {

    private static final Pattern PATTERN_NAME_F_NUMBER = Pattern.compile("(\\d{1,2})");

    public static boolean checkIfValid(EditText editText) {
        return PATTERN_NAME_F_NUMBER.matcher(editText.getText().toString()).matches();
    }
}
