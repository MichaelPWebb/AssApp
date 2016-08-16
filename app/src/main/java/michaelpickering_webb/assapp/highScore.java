package michaelpickering_webb.assapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class highScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
    }

    ArrayList<Boolean> answers = Quiz.getAnswerList();
    ArrayList<QandA> quiz = Quiz.getList();
}
