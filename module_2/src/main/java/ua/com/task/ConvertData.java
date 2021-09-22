package ua.com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.String.join;

public class ConvertData {

    private static final String FIRST_FORMAT = "yyyy/mm/dd";
    private static final String SECOND_FORMAT = "dd/mm/yyyy";
    private static final String THIRD_FORMAT = "mm-dd-yyyy";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ConvertData(){}

    public void formsData(String data){
        try {
            System.out.println("Choose your format");
            String format = reader.readLine();
            switch (format){
                case "1" : {
                   String[] firstFormat = data.split("/");
                   String year = firstFormat[0];
                   String month = firstFormat[1];
                   String day = firstFormat[2];
                   
                }
                case "2" :
                    String[] secondFormat = data.split("/");
                    String year = secondFormat[2];
                    String month = secondFormat[1];
                    String day = secondFormat[0];
                    String correctFormat = year + month + day;
                case "3" :
                    String[] thirdFormat = data.split("-");
                    String yearThird = thirdFormat[2];
                    String monthThird = thirdFormat[0];
                    String dayThird = thirdFormat[1];
                    String correctThirdFormat = yearThird + monthThird + dayThird;
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}
