package ua.com.Task;

import  java.util.Scanner;

public class timetable {
    public static void endOfTheLesson(int numberOfLesson) {
        int time;
        int lesson = 45;
        int bigBreak = 15;
        int smallBreak = 5;
        time = numberOfLesson * lesson + numberOfLesson / 2 * smallBreak
                + (numberOfLesson - 1) / 2 * bigBreak;
        System.out.println("The lesson are ending : " +
                (time / 60 + 9 + ":" + time % 60) + "\n");
    }

    public static void realization() {
        Scanner scanner = new Scanner(System.in);
        int numberOfLesson;
        if (!scanner.hasNextInt()) {
            System.out.println("This is not a number!\n");
            return;
        }
        numberOfLesson = scanner.nextInt();
        if (numberOfLesson > 0 && numberOfLesson <= 10) {
            endOfTheLesson(numberOfLesson);
        } else {
            System.out.println("Incorrect value!\n");
        }
    }
}