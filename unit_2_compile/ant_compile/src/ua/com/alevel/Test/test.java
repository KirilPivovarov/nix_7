package ua.com.alevel.Test;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public void hello() {
        System.out.println(StringUtils.upperCase("HelLo ant!"));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Current date and time: " + dateFormat.format(date));
    }

}