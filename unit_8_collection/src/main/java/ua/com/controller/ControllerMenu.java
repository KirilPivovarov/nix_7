package ua.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

public class ControllerMenu {


    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private final String[] optArray;
    private final Object objectWithMethods;

    public ControllerMenu(Object objectWithMethods, String... options) {
        LinkedList<String> optListWithoutExit = new LinkedList<>();
        for (String s : options) {
            if (!s.equals("exit")) {
                optListWithoutExit.add(s);
            }
        }
        optArray = optListWithoutExit.toArray(new String[0]);
        this.objectWithMethods = objectWithMethods;
    }

    public void loop() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("================");
            System.out.println("======Menu======");
            for (int i = 1; i <= optArray.length; i++) {
                if (!optArray[i - 1].equals("exit"))
                    System.out.println(i + "-" + optArray[i - 1]);
            }
            System.out.println("0-exit");
            System.out.println("================");
            System.out.println("Choose your option number");
            String input = reader.readLine();
            int selectedNumber;
            try {
                selectedNumber = Integer.parseInt(input);
                if (selectedNumber < 0 || selectedNumber > optArray.length) {
                    throw new NumberFormatException();
                }
                if (selectedNumber == 0)
                    break;
                Method method = objectWithMethods.getClass().getDeclaredMethod(optArray[selectedNumber - 1]);
                method.setAccessible(true);
                try {
                    method.invoke(objectWithMethods);
                } catch (InvocationTargetException e) {
                    e.getCause().printStackTrace();
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
            } catch (Exception e) {
                System.out.println("Something wrong");
                LOGGER_ERROR.error(e.getCause().getMessage());
                LOGGER_ERROR.error(Arrays.toString(e.getCause().getStackTrace()));
                e.printStackTrace();
                break;
            }
            System.out.println("Press any button");
            reader.readLine();
            System.out.println();
        }
    }
}
