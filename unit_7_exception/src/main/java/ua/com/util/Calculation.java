package ua.com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.entity.Date;

public class Calculation {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    public static long differenceBetweenDates(Date firstDate, Date secondDate) {
        LOGGER_INFO.info("Difference between dates");
        long firstDateIntoMilliseconds = ConvertDateToMilliseconds.dateIntoMilliseconds(firstDate);
        long secondDateIntoMilliseconds = ConvertDateToMilliseconds.dateIntoMilliseconds(secondDate);
        return Math.abs(firstDateIntoMilliseconds - secondDateIntoMilliseconds);
    }

    public static Date addMilliseconds(Date date, long milliseconds) {
        LOGGER_INFO.info("Add milliseconds to date");
        long dateIntoMilliseconds = ConvertDateToMilliseconds.dateIntoMilliseconds(date);
        return ConvertMillisecondsToDate.millisecondsToDate(dateIntoMilliseconds + milliseconds);
    }

    public static Date subtractMilliseconds(Date date, long milliseconds) {
        LOGGER_INFO.info("Subtract milliseconds from date");
        long dateIntoMilliseconds = ConvertDateToMilliseconds.dateIntoMilliseconds(date);
        return ConvertMillisecondsToDate.millisecondsToDate(dateIntoMilliseconds - milliseconds);
    }
}
