package ua.com.alevel.Test;

import org.apache.commons.math3.distribution.*;
import org.apache.commons.lang3.*;

public class test2 {

    public void hello2() {
        try {
            NormalDistribution normalDistribution = new NormalDistribution(8, 2);
            double randomValue = normalDistribution.sample();
            System.out.println("Your random number: " + (int) randomValue);
        } catch (NoClassDefFoundError e) {
            System.out.println(StringUtils.upperCase("Upps, some mistake(in ANT)"));
        }
    }

}