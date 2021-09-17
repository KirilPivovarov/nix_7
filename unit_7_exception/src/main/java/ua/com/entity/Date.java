package ua.com.entity;

import ua.com.exception.DateException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Date {

    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;


    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date() {
    }



    public void setDateAndTime(int year, int month, int day, int hour, int minute, int second, int mil) throws DateException {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hours = hour;
            this.minutes = minute;
            this.seconds = second;
            this.milliseconds = mil;
        } else {
            throw new DateException();
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        boolean isValid = true;
        int m = month - 1;

        if (m < 0 || m >= 12) {
            isValid = false;
            System.out.println("date is not valid");
        }

        int maxDate = daysInMonth[m];
        if (m == 1 && isLeapYear(year)) {
            maxDate = 29;
        }

        if (day < 1 || day > maxDate) {
            isValid = false;
            System.out.println("date is not valid, max date in this month is " + maxDate);
        }
        return isValid;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Date)) {
            return false;
        }
        Date date = (Date) obj;
        return (this.year == date.year) && (this.month == date.month) && (this.day == date.day);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + month;
        result = 31 * result + day;

        return result;
    }
}
