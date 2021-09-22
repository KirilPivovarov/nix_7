package ua.com;


import ua.com.task.ConvertData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ConvertData data = new ConvertData();
        System.out.println("Format");
        String format = reader.readLine();
        data.formsData(format);
    }
}
