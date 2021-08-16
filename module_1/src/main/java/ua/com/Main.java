package ua.com;

import ua.com.level1.task1.CountUniqueSymbol;
import ua.com.level1.task2.HorseMove;
import ua.com.level1.task3.TriangleSquare;
import ua.com.level2.StringValidator;
import ua.com.level3.GameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        boolean startProgram = true;
        while (startProgram) {
            System.out.println(" ");
            System.out.println("to call the first level enter 1");
            System.out.println("to call the second level enter 2");
            System.out.println("to call the third level enter 3");
            System.out.println("to exit enter 0");
            System.out.println(" ");

            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    System.out.println("to call the first task enter 1 (CountUniqueSymbol)");
                    System.out.println("to call the second task enter 2(HorseMove)");
                    System.out.println("to call the third task enter 3(TriangleSquare)");

                    int chooseInFirstLevel = scanner.nextInt();

                    switch (chooseInFirstLevel) {
                        case 1:
                            CountUniqueSymbol.run();
                            break;
                        case 2:
                            HorseMove.Horserun();
                            break;
                        case 3:
                            TriangleSquare.triangleArea();
                            break;
                    }
                    break;
                }
                case 2:
                    System.out.println("Enter a string with brackets");
                    String word = reader.readLine();
                    StringValidator validator = new StringValidator(word);
                    System.out.println(validator.isValid());
                    break;
                case 3:
                    System.out.println("Welcome to Game of Life");
                    GameOfLife.startLife();
                    break;
                case 0 :
                    System.out.println("Thank you, User");
                     startProgram = false;
                    break;
                default:
                   System.out.println("Incorect input");
            }
        }
    }
}
