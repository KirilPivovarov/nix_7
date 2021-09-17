package ua.com.controller;

import ua.com.entity.Date;
import ua.com.service.ConvertStringToDate;
import ua.com.service.ConvertToString;
import ua.com.service.checkFormat;
import ua.com.util.Sorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortingListOfDates {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final ConvertStringToDate CONVERT = new ConvertStringToDate();
    private static final ConvertToString PRINT_DATE = new ConvertToString();

    public static void sorting() throws NumberFormatException, IOException {
        ArrayList<Date> dates = new ArrayList<>();

        String format;
        do {
            System.out.println("Choose date input format\n" +
                    "1. dd/mm/yyyy 00:00:00:000 (or dd-mm-yyyy)\n" +
                    "2. m/d/yyyy 00:00:00:000 (or m-d-yyyy)\n" +
                    "3. mmm-d-yy 00:00:00:000 (or Month d yyyy)\n" +
                    "4. dd-mmm-yyyy 00:00:00:000 (or dd Month yyyy)");
            format = reader.readLine();
        } while (Integer.parseInt(format) > 4 || Integer.parseInt(format) <= 0);

        try {
            System.out.print("Enter count of dates:");
            String count = reader.readLine();
            for (int i = 0; i < Integer.parseInt(count); i++) {
                System.out.print("Enter the date:");
                String date;

                boolean isValid = true;
                do {
                    if (!isValid) {
                        System.out.println("Incorrect input, try again");
                    }
                    date = reader.readLine();
                    isValid = false;
                } while (checkFormat.check(date, format) || checkFormat.checkFormatOfTime(date));

                Date myDate = null;
                try {
                    myDate = CONVERT.stringToDate(date, format);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dates.add(myDate);
            }

            System.out.println("1. Descending sort\n" + "2. Ascending sort");
            String choiceSort = reader.readLine();
            ArrayList<Date> sortedDates = Sorted.sortDates(dates, choiceSort);

            System.out.println("Choose format of date\n" +
                    "1. dd/mm/yy 00:00:00:000\n" +
                    "2. m/d/yy 00:00:00:000\n" +
                    "3. Month d yyyy 00:00:00:000\n" +
                    "4. dd Month yy 00:00:00:000");
            String choiceFormat = reader.readLine();
            System.out.println("The dates:");
            for (Date date : sortedDates) {
                System.out.print(PRINT_DATE.dateToString(date, choiceFormat));
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Incorrect!");
        }
    }
}
