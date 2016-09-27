package michaelpickering_webb.assapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class highScore extends AppCompatActivity {


    public static ArrayList<Boolean> answers = Quiz.getAnswerList();
    ArrayList<String> myAnswers = Quiz.getMyAnswerList();
    ArrayList<String> incorrectQList = new ArrayList<>();
    ArrayList<String> incorrectAList = new ArrayList<>();
    ArrayList<String> myIncorrectAnswer = new ArrayList<>();
    int correctNum = 0;
    int incorrectNum = 0;
    String fraction = "";
    public int y = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        for(int i = 0;i < answers.size(); i++){

            if(answers.get(i).equals(true)){

                correctNum++;

            }
            else{

                incorrectNum++;

            }

            MainActivity.Score.add(new HighScoreTable(correctNum, incorrectNum));

        }

        fraction = "You got " + HighScoreTable.getCorrect() + "/" + HighScoreTable.getTotal();

        TextView textViewToChange11 = (TextView) this.findViewById(R.id.textView3);
        textViewToChange11.setText(fraction);

        TextView textViewToChange12 = (TextView) this.findViewById(R.id.textView4);
        textViewToChange12.setText(HighScoreTable.getPercentage());


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                clear();
                Intent intent = new Intent(highScore.this,MainActivity.class);
                startActivity(intent);

            }
        }, 3000);

    }

    public void clear(){


        for( int i = 0; i < myAnswers.size();i++){

            myAnswers.remove(i);
        }


        for( int i = 0; i < answers.size();i++){

            answers.remove(i);
        }

    }

}
