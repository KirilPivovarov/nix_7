package ua.com.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class countsTheSumOFLettersInAString {
    public  static void sortedLetters() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String string = reader.readLine();
        String[]letters=string.split("[^a-zA-Z]?");
        TreeMap<String,Integer> map=new TreeMap<>();
        Arrays.stream(letters).filter(x->!x.equals("")).forEach(x-> {
            if (map.containsKey(x)) {
                map.replace(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        });
        map.forEach((key,value)->System.out.println(key+" - "+value));
    }
}