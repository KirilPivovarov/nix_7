package ua.com.alevel;

import java.math.BigDecimal;

public class Primitive {

    private int a;

    public int getA() {
        return a;
    }

    public void casting() {
        int i = Integer.MAX_VALUE;
        ++i;
        System.out.println("i = " + i);

        i = (int) Long.MAX_VALUE;
        System.out.println("i = " + i);
    }

    public void doubleProblem() {
        System.out.println(2.0 - 1.9);
        BigDecimal left = new BigDecimal("2.0");
        BigDecimal right = new BigDecimal("1.9");
        BigDecimal res = left.subtract(right);
        System.out.println("res = " + res.toString());
        System.out.println((float) (2.0f - 1.9f));
    }

    public void array() {
        int[] ints = { 0, 9 };
        try {
            System.out.println(ints[3]);
        } catch (IndexOutOfBoundsException r) {
            System.out.println(r.getMessage());
        }

//        int a;
//        System.out.println(a);
    }

    public void binary() {
        int a = 27;
        a = a * 2;
        System.out.println("a = " + a);

        a = 27;
        int b = a << 1;
        System.out.println("b = " + b);

        a = 23 & 3;
    }
}
