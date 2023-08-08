package ru.kirikura;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String[] filenames = {
                "m.202301.csv",
                "y.2023.csv",
                "m123.csv",
                "y2023.csv",
                "m.2023012.csv"
        };

        String regex = "^[my]\\.(\\d{4}|\\d{6})\\.csv$";
        Pattern pattern = Pattern.compile(regex);

        for (String filename : filenames) {
            Matcher matcher = pattern.matcher(filename);
            if (matcher.matches()) {
                System.out.println(filename + " соответствует формату.");
            } else {
                System.out.println(filename + " не соответствует формату.");
            }
        }
    }
}
