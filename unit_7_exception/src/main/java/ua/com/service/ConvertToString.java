package ua.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.entity.Date;

import java.time.LocalDate;

public class ConvertToString {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    private final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    public String dateToString(Date date, String choice) {
        String stringDate = "";
        switch (choice) {
            case "1":
                System.out.println(firstFormat(date, stringDate));
                break;
            case "2":
                System.out.println(secondFormat(date, stringDate));
                break;
            case "3":
                System.out.println(thirdFormat(date, stringDate));
                break;
            case "4":
                System.out.println(fourthFormat(date, stringDate));
                break;
            default:
                System.out.println("Incorrect input");
        }
        return stringDate;
    }

    private String firstFormat(Date date, String stringDate) {
        LOGGER_INFO.info("Print first format of date");
        if (date.getDay() == 0) {
            stringDate += "1";
        }
        stringDate += createDoubleZero(date.getDay()) + "/";
        for (int i = 0; i < MONTHS.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += createDoubleZero(date.getMonth()) + "/";
            }
        }

        stringDate += date.getYear() + " ";

        stringDate += createDoubleZero(date.getHours()) + ":";
        stringDate += createDoubleZero(date.getMinutes()) + ":";
        stringDate += createDoubleZero(date.getSeconds()) + ":";
        stringDate += createTripleZero(date.getMilliseconds());

        return stringDate;
    }

    private String secondFormat(Date date, String stringDate) {
        LOGGER_INFO.info("Print second format of date");
        if (date.getDay() == 0) {
            stringDate += "1";
        }

        for (int i = 0; i < MONTHS.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += date.getMonth() + "/";
            }
        }

        stringDate += date.getDay() + "/";
        stringDate += date.getYear() + " ";

        stringDate += createDoubleZero(date.getHours()) + ":";
        stringDate += createDoubleZero(date.getMinutes()) + ":";
        stringDate += createDoubleZero(date.getSeconds()) + ":";
        stringDate += createTripleZero(date.getMilliseconds());

        return stringDate;
    }

    private String thirdFormat(Date date, String stringDate) {
        LOGGER_INFO.info("Print third format of date");
        for (int i = 0; i < MONTHS.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += MONTHS[i] + " ";
            }
        }

        if (date.getDay() == 0) {
            stringDate += "1";
        }
        stringDate += date.getDay() + " ";
        stringDate += date.getYear() + " ";

        stringDate += createDoubleZero(date.getHours()) + ":";
        stringDate += createDoubleZero(date.getMinutes()) + ":";
        stringDate += createDoubleZero(date.getSeconds()) + ":";
        stringDate += createTripleZero(date.getMilliseconds());

        return stringDate;
    }

    private String fourthFormat(Date date, String stringDate) {
        LOGGER_INFO.info("Print fourth format of date");
        if (date.getDay() == 0) {
            stringDate += "1";
        }
        stringDate += createDoubleZero(date.getDay()) + " ";

        for (int i = 0; i < MONTHS.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += MONTHS[i] + " ";
            }
        }
        stringDate += date.getYear() + " ";

        stringDate += createDoubleZero(date.getHours()) + ":";
        stringDate += createDoubleZero(date.getMinutes()) + ":";
        stringDate += createDoubleZero(date.getSeconds()) + ":";
        stringDate += createTripleZero(date.getMilliseconds());

        return stringDate;
    }

    private String createTripleZero(int milliseconds) {
        if (milliseconds < 10) {
            return "00" + milliseconds;
        }
        if (milliseconds < 100) {
            return "0" + milliseconds;
        }
        return milliseconds + "";
    }

    private String createDoubleZero(int value) {
        if (value < 10) {
            return "0" + value;
        }
        return value + "";
    }
}
