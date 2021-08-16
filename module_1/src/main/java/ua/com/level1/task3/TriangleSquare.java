package ua.com.level1.task3;

import java.util.Scanner;

public class TriangleSquare {

    public static void triangleArea() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter point А coordinates ax and ay");
        int ax = console.nextInt();
        int ay = console.nextInt();
        System.out.println("Please enter point B coordinates bx and by");
        int bx = console.nextInt();
        int by = console.nextInt();
        System.out.println("Please enter point C coordinates cx and cy");
        int cx = console.nextInt();
        int cy = console.nextInt();
        int AB = (int) Math.sqrt(Math.pow((bx - ax), 2) * Math.pow((by - ay), 2));
        int AC = (int) Math.sqrt(Math.pow((cx - ax), 2) * Math.pow((cy - ay), 2));
        int BC = (int) Math.sqrt(Math.pow((cx - bx), 2) * Math.pow((cy - by), 2));
        if ((AB + AC > BC) || (AC + BC > AB) || (AB + BC > AC)) {
            double Sabc = ((ax - bx) * (cy - by) - (cx - bx) * (ay - by)) / 2.0;
            System.out.println("Area of triangle ABC = " + Sabc);
        } else
            System.out.println("Sorry, a triangle with such coordinates does not exist");
    }
}
