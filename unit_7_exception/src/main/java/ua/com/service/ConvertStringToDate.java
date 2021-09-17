package ua.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.entity.Date;

public class ConvertStringToDate {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    public Date stringToDate(String date, String choice) {
        Date Date = new Date();
        switch (choice) {
            case "1":
                Date = firstFormat(date);
                break;
            case "2":
                Date = secondFormat(date);
                break;
            case "3":
               Date  = thirdFormat(date);
                break;
            case "4":
                Date = fourthFormat(date);
                break;
            default:
                System.out.println("Incorrect input");
        }
        return Date;
    }

    public static Date firstFormat(String stringDate) {
        LOGGER_INFO.info("Converting first format to string");
        Date myDate = new Date();

        String delimiter;
        if (stringDate.contains("/")) {
            delimiter = "/";
        } else {
            delimiter = "-";
        }

        String[] split = new String[4];
        switch (delimiter) {
            case "/":
                split = stringDate.split("[/ ]", 4);
                break;
            case "-":
                split = stringDate.split("[- ]", 4);
                break;
        }
        try {
            if (!split[0].equals("")) {
                myDate.setDay(Integer.parseInt(split[0]));
            } else {
                myDate.setDay(1);
            }
            if (!split[1].equals("")) {
                myDate.setMonth(Integer.parseInt(split[1]));
            } else {
                myDate.setMonth(1);
            }
            if (!split[2].equals("")) {
                myDate.setYear(Integer.parseInt(split[2]));
            } else {
                myDate.setYear(0);
            }
            if (split.length > 3) {
                setTime(myDate, split[3]);
            }
            return myDate;
        } catch (NumberFormatException e) {
            LOGGER_ERROR.error("Incorrect number format");
            throw new NumberFormatException();
        }
    }

    public static Date secondFormat(String stringDate) {
        LOGGER_INFO.info("Converting second format to string");
        Date myDate = new Date();

        String delimiter;
        if (stringDate.contains("/")) {
            delimiter = "/";
        } else {
            delimiter = "-";
        }

        String[] split = new String[4];
        switch (delimiter) {
            case "/":
                split = stringDate.split("[/ ]", 4);
                break;
            case "-":
                split = stringDate.split("[- ]", 4);
                break;
        }
        try {
            if (!split[0].equals("")) {
                myDate.setMonth(Integer.parseInt(split[0]));
            } else {
                myDate.setMonth(1);
            }
            if (!split[1].equals("")) {
                myDate.setDay(Integer.parseInt(split[1]));
            } else {
                myDate.setDay(1);
            }
            if (!split[2].equals("")) {
                myDate.setYear(Integer.parseInt(split[2]));
            } else {
                myDate.setYear(0);
            }
            if (split.length > 3) {
                setTime(myDate, split[3]);
            }
            return myDate;
        } catch (NumberFormatException e) {
            LOGGER_ERROR.error("Incorrect number format");
            throw new NumberFormatException();
        }
    }

    public static Date thirdFormat(String stringDate) {
        LOGGER_INFO.info("Converting third format to string");
        Date myDate = new Date();

        String[] split;
        if (stringDate.contains("-")) {
            split = stringDate.split("[- ]", 4);
        } else {
            split = stringDate.split("[ ]", 4);
        }
        try {
            int month;
            if (!split[0].equals("")) {
                for (int i = 0; i < MONTHS.length; i++) {
                    if (split[0].equals(MONTHS[i])) {
                        month = i + 1;
                        myDate.setMonth(month);
                    }
                }
            } else {
                myDate.setMonth(1);
            }
            if (!split[1].equals("")) {
                myDate.setDay(Integer.parseInt(split[1]));
            } else {
                myDate.setDay(1);
            }
            if (!split[2].equals("")) {
                myDate.setYear(Integer.parseInt(split[2]));
            } else {
                myDate.setYear(0);
            }

            if (split.length > 3) {
                setTime(myDate, split[3]);
            }
            return myDate;
        } catch (NumberFormatException e) {
            LOGGER_ERROR.error("Incorrect number format");
            throw new NumberFormatException();
        }
    }

    public static Date fourthFormat(String stringDate) {
        LOGGER_INFO.info("Converting fourth format to string");
        Date myDate = new Date();

        String[] split;
        if (stringDate.contains("-")) {
            split = stringDate.split("[- ]", 4);
        } else {
            split = stringDate.split("[ ]", 4);
        }
        try {
            if (!split[0].equals("")) {
                myDate.setDay(Integer.parseInt(split[0]));
            } else {
                myDate.setDay(1);
            }
            int month;
            if (!split[1].equals("")) {
                for (int i = 0; i < MONTHS.length; i++) {
                    if (split[1].equals(MONTHS[i])) {
                        month = i + 1;
                        myDate.setMonth(month);
                    }
                }
            } else {
                myDate.setMonth(1);
            }
            if (!split[2].equals("")) {
                myDate.setYear(Integer.parseInt(split[2]));
            } else {
                myDate.setYear(0);
            }

            if (split.length > 3) {
                setTime(myDate, split[3]);
            }
            return myDate;
        } catch (NumberFormatException e) {
            LOGGER_ERROR.error("Incorrect number format");
            throw new NumberFormatException();
        }
    }

    public static void setTime(Date date, String time) {
        String[] splitter = time.split(":");
        try {
            for (int i = 0; i < splitter.length; i++) {
                switch (i) {
                    case 0:
                        date.setHours(Integer.parseInt(splitter[0]));
                        break;
                    case 1:
                        date.setMinutes(Integer.parseInt(splitter[1]));
                        break;
                    case 2:
                        date.setSeconds(Integer.parseInt(splitter[2]));
                        break;
                    case 3:
                        date.setMilliseconds(Integer.parseInt(splitter[3]));
                        break;
                }
            }
        } catch (NumberFormatException e) {
            LOGGER_ERROR.error("Incorrect number format");
            throw new NumberFormatException();
        }
    }
}
