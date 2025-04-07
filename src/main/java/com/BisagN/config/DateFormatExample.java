package com.BisagN.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        String inputDate = "Sat Jun 10 00:00:00 IST 2023";
        String outputFormat = "MM/dd/yyyy";
        
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
        
        try {
            Date date = inputDateFormat.parse(inputDate);
            String formattedDate = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}