package ua.com.Task;

import java.util.Scanner;

public class countsTheSumOfTheNumberInTheString {



    public static void sumOfNumber() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int elseChar = 0;
        String string = scanner.nextLine();
        char[] result = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                sum += Character.getNumericValue(string.charAt(i));
            } else {
                elseChar++;
            }
        }
        if (elseChar == string.length()) {
            System.out.println("No number!\n");
        } else {
            System.out.println("Sum of number of in a strig  " + sum + "\n");
        }
    }
}
