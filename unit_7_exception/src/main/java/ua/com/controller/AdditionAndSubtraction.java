package ua.com.controller;

import ua.com.entity.Date;
import ua.com.service.ConvertStringToDate;
import ua.com.service.ConvertToString;
import ua.com.service.checkFormat;
import ua.com.util.Calculation;
import ua.com.util.ConvertDateToMilliseconds;

import java.util.Scanner;

public class AdditionAndSubtraction {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ConvertStringToDate CONVERT = new ConvertStringToDate();
    private static final ConvertToString PRINT_DATE = new ConvertToString();

    public static void addition() {
        String format;
        do {
            System.out.println("Choose date input format\n" +
                    "1. dd/mm/yy 00:00:00:000 (or dd-mm-yy)\n" +
                    "2. m/d/yyyy 00:00:00:000 (or m-d-yyyy)\n" +
                    "3. mmm-d-yy 00:00:00:000 (or Month d yyyy)\n" +
                    "4. dd-mmm-yyyy 00:00:00:000 (or dd Month yyyy)");
            format = SCANNER.nextLine();
        } while (Integer.parseInt(format) > 4 || Integer.parseInt(format) <= 0);

        System.out.print("Enter the date:");
        String date;

        boolean isValid = true;
        do {
            if (!isValid) {
                System.out.println("Incorrect input, try again");
            }
            date = SCANNER.nextLine();
            isValid = false;
        } while (checkFormat.check(date, format) || checkFormat.checkFormatOfTime(date));

        Date myDate = null;
        try {
            myDate = CONVERT.stringToDate(date, format);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("Choose what do you want to add:");
                menu();
                long mil;
                String choice = SCANNER.nextLine();
                switch (choice) {
                    case "1":
                        System.out.print("Enter count of years:");
                        String years = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.yearToMilliseconds(Integer.parseInt(years));
                        myDate = Calculation.addMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "2":
                        System.out.print("Enter count of days:");
                        String days = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.dayToMilliseconds(Integer.parseInt(days));
                        myDate = Calculation.addMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "3":
                        System.out.print("Enter count of hours:");
                        String hours = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.hoursToMilliseconds(Integer.parseInt(hours));
                        myDate = Calculation.addMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "4":
                        System.out.print("Enter count of minutes:");
                        String minutes = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.minutesToMilliseconds(Integer.parseInt(minutes));
                        myDate = Calculation.addMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "5":
                        System.out.print("Enter count of seconds:");
                        String seconds = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.secondsToMilliseconds(Integer.parseInt(seconds));
                        myDate = Calculation.addMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "6":
                        System.out.print("Enter count of milliseconds:");
                        String milliseconds = SCANNER.nextLine();
                        myDate = Calculation.addMilliseconds(myDate, Integer.parseInt(milliseconds));
                        printDateFormat(myDate);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Incorrect input!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Incorrect!");
        }
    }

    public static void subtraction() {
        String format;
        do {
            System.out.println("Choose date input format\n" +
                    "1. dd/mm/yyyy 00:00:00:000 (or dd-mm-yyyy)\n" +
                    "2. m/d/yyyy 00:00:00:000 (or m-d-yyyy)\n" +
                    "3. mmm-d-yy 00:00:00:000 (or Month d yyyy)\n" +
                    "4. dd-mmm-yyyy 00:00:00:000 (or dd Month yyyy)");
            format = SCANNER.nextLine();
        } while (Integer.parseInt(format) > 4 || Integer.parseInt(format) <= 0);

        System.out.print("Enter the date:");
        String date;

        boolean isValid = true;
        do {
            if (!isValid) {
                System.out.println("Incorrect input, try again");
            }
            date = SCANNER.nextLine();
            isValid = false;
        } while (checkFormat.check(date, format) || checkFormat.checkFormatOfTime(date));

        Date myDate = null;
        try {
            myDate = CONVERT.stringToDate(date, format);
            System.out.println(myDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("Choose what do you want to subtract:");
                menu();
                long mil;
                String choice = SCANNER.nextLine();
                switch (choice) {
                    case "1":
                        System.out.print("Enter count of years:");
                        String years = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.yearToMilliseconds(Integer.parseInt(years));
                        myDate = Calculation.subtractMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "2":
                        System.out.print("Enter count of days:");
                        String days = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.dayToMilliseconds(Integer.parseInt(days));
                        myDate = Calculation.subtractMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "3":
                        System.out.print("Enter count of hours:");
                        String hours = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.hoursToMilliseconds(Integer.parseInt(hours));
                        myDate = Calculation.subtractMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "4":
                        System.out.print("Enter count of minutes:");
                        String minutes = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.minutesToMilliseconds(Integer.parseInt(minutes));
                        myDate = Calculation.subtractMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "5":
                        System.out.print("Enter count of seconds:");
                        String seconds = SCANNER.nextLine();
                        mil = ConvertDateToMilliseconds.secondsToMilliseconds(Integer.parseInt(seconds));
                        myDate = Calculation.subtractMilliseconds(myDate, mil);
                        printDateFormat(myDate);
                        break;
                    case "6":
                        System.out.print("Enter count of milliseconds:");
                        String milliseconds = SCANNER.nextLine();
                        myDate = Calculation.subtractMilliseconds(myDate, Integer.parseInt(milliseconds));
                        printDateFormat(myDate);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Incorrect input!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Incorrect!");
        }
    }

    private static void menu() {
        System.out.println("1-Years");
        System.out.println("2-Days");
        System.out.println("3-Hours");
        System.out.println("4-Minutes");
        System.out.println("5-Seconds");
        System.out.println("6-Milliseconds");
        System.out.println("0-Exit");
        System.out.println();
    }

    private static void printDateFormat(Date date) {
        System.out.println("Choose format of date\n" +
                "1. dd/mm/yy 00:00:00:000\n" +
                "2. m/d/yy 00:00:00:000\n" +
                "3. Month d yyyy 00:00:00:000\n" +
                "4. dd Month yyyy 00:00:00:000");
        String format = SCANNER.nextLine();
        System.out.println("The date:");
        System.out.print(PRINT_DATE.dateToString(date, format));
    }
}
