package ua.com;

import com.revers.reversesString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String word;
     private static int choose;

    public static void main(String[] args) {
        System.out.println("Reversrse string - 1");
        System.out.println("Reverse on the specified line - 2");
        System.out.println("Reverse according to the indicated indices - 3");
        System.out.println("Program stop - 0");
        boolean startProgram = true;

        while (startProgram) {
            try {
                System.out.println("Input your choose : ");
                 choose = scanner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Incorrect input");
                break;
            }
            if (choose == 0) {
                System.out.println("Thank you, User");
                startProgram = false;
                break;
            } else if (choose < 0 || choose > 3) {
                System.out.println("Incorrect input ");
                break;
            }

            System.out.println("Input your string : ");
            try {
                word = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (choose) {
                case 1:
                    System.out.println(reversesString.reverse(word));
                    break;
                case 2:
                    System.out.println("Input reverse substring");
                    String substring = scanner.next();
                    System.out.println(reversesString.reverse(word, substring));
                    break;
                case 3:
                    System.out.println("Input first and last idex reverse string : ");
                    int firstIndex = scanner.nextInt();
                    int lastIndex = scanner.nextInt();
                    try {
                        System.out.println(reversesString.reverse(word, firstIndex, lastIndex));
                    }catch (InputMismatchException e){
                        System.out.println("Incorrect input");
                    }
                    break;
            }
        }
    }
}

