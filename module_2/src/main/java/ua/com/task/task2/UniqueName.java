package ua.com.task.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueName {

    private static final Scanner in = new Scanner(System.in);
    private static final String filepath = "D:\\myProjectFile\\nix_7\\module_2\\files\\names.txt";

   public void run() {
        System.out.println("Second task");
        boolean isLoop = true;
        while (isLoop) {
            System.out.println("1. Enter names by yourself\n" +
                            "2. Take data from names.txt file\n" +
                    "For exit enter any another symbol");
            switch (in.nextLine()) {
                case "1":
                    inputByYourself();
                    break;
                case "2":
                    testFromFile();
                    break;
                default: {
                    isLoop = false;
                }
            }
        }
    }

    private void inputByYourself() {
        System.out.println();
        System.out.println("Enter names by separating them with the space bar (Alex Iegor Vasya Lubov Andrey)");
        String[] names = in.nextLine().split(" ");
        ArrayList<String> listOfNames = new ArrayList<>(Arrays.asList(names));

        System.out.println("First unique name from list: ");
        System.out.println(findName(listOfNames));
    }

    private void testFromFile() {
        System.out.println();
        try {
            Path path = Paths.get(filepath);
            ArrayList<String> namesFromFile = (ArrayList<String>) Files.readAllLines(path);
            System.out.println("The list of names from file names.txt");
            namesFromFile.forEach(n -> System.out.print(n + " "));

            System.out.println("First unique name from list: ");
            System.out.println(findName(namesFromFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String findName(List<String> nameList) {

       if(nameList.size() > 0){
        String name;
        List<String> res = nameList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
            name = res.get(0);
            return name;
    }else {
       return "Not unique name";
       }
    }
}