package ua.com;

import ua.com.controller.ControllerMenu;
import ua.com.controller.MathSetController;

import java.io.IOException;

public class mainCollection {
    public static void main(String[] args) {
        MathSetController controller = new MathSetController();
        ControllerMenu menu = new ControllerMenu(controller, "initializeMathSet", "add", "join", "intersection", "sortDesc", "sortAsc", "get",
                "getMax", "getMin", "getAverage", "getMedian", "cut", "clear", "printSet");
        try {
            menu.loop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
