package ua.com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.entity.Date;

import java.util.ArrayList;

public class Sorted {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

    public static ArrayList<Date> sortDates(ArrayList<Date> dates, String choice) {
        boolean isSorted;
        int size = dates.size();
        switch (choice) {
            case "1":
                LOGGER_INFO.info("Descending sort");
                System.out.println("Descending sort");
                do {
                    isSorted = true;
                    for (int i = 0; i < size - 1; i++) {
                        if (ConvertDateToMilliseconds.dateIntoMilliseconds(dates.get(i)) < ConvertDateToMilliseconds.dateIntoMilliseconds(dates.get(i + 1))) {
                            Date date = dates.get(i);
                            dates.set(i, dates.get(i + 1));
                            dates.set(i + 1, date);
                            isSorted = false;
                        }
                    }
                } while (!isSorted);
                return dates;
            case "2":
                LOGGER_INFO.info("Ascending sort");
                System.out.println("Ascending sort");
                do {
                    isSorted = true;
                    for (int i = 0; i < size - 1; i++) {
                        if (ConvertDateToMilliseconds.dateIntoMilliseconds(dates.get(i)) > ConvertDateToMilliseconds.dateIntoMilliseconds(dates.get(i + 1))) {
                            Date date = dates.get(i);
                            dates.set(i, dates.get(i + 1));
                            dates.set(i + 1, date);
                            isSorted = false;
                        }
                    }
                } while (!isSorted);
                return dates;
            default:
                return dates;
        }
    }
}
