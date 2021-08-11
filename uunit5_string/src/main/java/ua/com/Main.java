package ua.com;

import ua.com.libs.reversesString;
import java.util.Scanner;

public class Main {

   public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Reversrse string - 1");
        System.out.println( "Reverse on the specified line - 2" );
        System.out.println("Reverse according to the indicated indices - 3");
        System.out.println("Program stop - 0");


        System.out.println("Input your String : ");
        String word = scanner.nextLine().trim();
        int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    reversesString.reverse(word);
                  break;


                case 2: {
                    System.out.println("Input reverse substring");
                    String substring = scanner.nextLine();
                    reversesString.reverse(word, substring);
                    break;
                }

                case 3: {
                    System.out.println("Input first and last idex reverse string : ");
                    int firstIndex = scanner.nextInt();
                    int lastIndex = scanner.nextInt();
                    reversesString.reverse(word, firstIndex, lastIndex);
                    break;
                }

            }

        }
    }

