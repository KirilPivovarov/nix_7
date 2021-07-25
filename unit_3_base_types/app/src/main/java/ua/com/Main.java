package ua.com;

import ua.com.Task.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Tasks: ");
        System.out.println(" 1 - count the sum of the number in the string(Task1) ");
        System.out.println("2 - counting letters in a string(Task2)");
        System.out.println("3 - timetable(Task3)");
        System.out.println("0 - Exit");


        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.print("This is not a number! Try again >>");
                scanner.next();
            }
            int choice = scanner.nextInt();
            if (choice > 3 || choice < 0) {
                System.out.print("incorent choise ");
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter string : ");
                    countsTheSumOfTheNumberInTheString.sumOfNumber();
                    break;
                case 2:
                    System.out.print("Enter string : ");
                    countsTheSumOFLettersInAString.sortedLetters();
                    break;
                case 3:
                    System.out.print("Enter the number of lesson : ");
                    timetable.realization();
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Incorrect value! Try again.\n");


            }

        }
    }
}
