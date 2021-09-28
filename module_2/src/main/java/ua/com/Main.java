package ua.com;


import ua.com.task.task1.ControllerData;
import ua.com.task.task2.UniqueName;
import ua.com.task.task3.FindMostProfitWay;

import  java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ControllerData controllerData = new ControllerData();
        UniqueName uniqueName = new UniqueName();
        FindMostProfitWay findMostProfitWay = new FindMostProfitWay();

        boolean ifLoop = true;
        while (ifLoop) {
            System.out.println("\nMenu:\n" +
                    "1. List of dates in a list without delimiters\n" +
                    "2. Find first unique name from the list of names\n" +
                    "3. Find the cheapest way between towns\n" +
                    "For exit enter any another symbol");

            String index = scan.nextLine();
            switch (index) {
                case "1":
                    controllerData.run();
                    break;
                case "2":
                    uniqueName.run();
                    break;
                case "3":
                    findMostProfitWay.run();
                    break;
                default:
                    ifLoop = false;
            }
        }
    }
}