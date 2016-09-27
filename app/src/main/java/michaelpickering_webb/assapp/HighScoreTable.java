package michaelpickering_webb.assapp;

import java.util.ArrayList;

/**
 * Created by micha on 18/08/2016.
 */
public class HighScoreTable {

    public static int NumCorrect;
    public static int NumIncorrect;
    public static int total;
    public static String Percentage;
    public static String NumberCorrect;
    public static String NumberIncorrect;
    public static String TotalS;


    public HighScoreTable(int correct, int incorrect){

        NumCorrect = correct;
        NumIncorrect = incorrect;
        total = NumCorrect + NumIncorrect;

    }


    public static String getCorrect(){

        NumberCorrect = Integer.toString(NumCorrect);

        return NumberCorrect;

    }

    public static String getIncorrect(){

        NumberIncorrect = Integer.toString(NumIncorrect);

        return NumberIncorrect;

    }

    public static String getTotal(){

        TotalS = Integer.toString(total);

        return TotalS;
    }

    public static String getPercentage(){

        double percent = (double) NumCorrect / total * 100;
        Percentage = String.format("%.2f", percent) + "%";

        return Percentage;

    }
}
