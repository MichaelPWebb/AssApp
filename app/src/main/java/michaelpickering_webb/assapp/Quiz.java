package michaelpickering_webb.assapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;


public class Quiz extends AppCompatActivity {

    DBHandler db = new DBHandler(this);

    public int i = 0;
    public int check = 0;
    static ArrayList<Boolean> answerList = new ArrayList<>();
    ArrayList<Question> quizlist = new ArrayList<>();
    static ArrayList<String> myAnswerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        i=0;
        quizlist = db.getAllQuestions();
        startQuiz();

    }


    public void startQuiz(){


        Question quiz = quizlist.get(i);

        final TextView textViewToChange = (TextView) findViewById(R.id.textView);
        textViewToChange.setText(quizlist.get(i).getQUESTION());

        final TextView textViewToChange1 = (TextView) findViewById(R.id.checkBox);
        textViewToChange1.setText(quiz.getOPTA());
        if(quiz.getOPTA().equals("")){
            textViewToChange1.setVisibility(View.VISIBLE);
        }
        else{
            textViewToChange1.setVisibility(View.VISIBLE);
        }

        final TextView textViewToChange2 = (TextView) findViewById(R.id.checkBox2);
        textViewToChange2.setText(quiz.getOPTB());
        if(quiz.getOPTB().equals("")){
            textViewToChange2.setVisibility(View.VISIBLE);
        }
        else{
            textViewToChange2.setVisibility(View.VISIBLE);
        }

        final TextView textViewToChange3 = (TextView) findViewById(R.id.checkBox3);
        textViewToChange3.setText(quiz.getOPTC());
        if(quiz.getOPTC().equals("")){
            textViewToChange3.setVisibility(View.VISIBLE);
        }
        else{
            textViewToChange3.setVisibility(View.VISIBLE);
        }

        final TextView textViewToChange4 = (TextView) findViewById(R.id.checkBox4);
        textViewToChange4.setText(quiz.getOPTD());
        if(quiz.getOPTD().equals("")){
            textViewToChange4.setVisibility(View.INVISIBLE);
        }
        else{
            textViewToChange4.setVisibility(View.VISIBLE);
        }


    }


    public static ArrayList<Boolean> getAnswerList(){

        ArrayList<Boolean> boolList = answerList;

        return boolList;

    }

    public static ArrayList<String> getMyAnswerList(){

        return myAnswerList;
    }

    public void onButtonClickCancel(View view) {

        List<Question> quest = db.getAllQuestions();
        final List<Question> quizlist = quest;
        final Question quiz = quizlist.get(i);
        final TextView textViewToChange = (TextView) findViewById(R.id.textView2);

        if(check == 0) {

            textViewToChange.setTextSize(40);

            final String answer = getAnswered();

            if (answer.equals(quiz.getANSWER())) {

                textViewToChange.setVisibility(View.VISIBLE);
                textViewToChange.setText("Correct");
                textViewToChange.setTextColor(Color.parseColor("#006F00"));
                textViewToChange.setBackgroundColor(Color.parseColor("#00FF00"));
                answerList.add(true);
                myAnswerList.add(answer);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        textViewToChange.setText("");
                        textViewToChange.setVisibility(View.INVISIBLE);
                        if (i < (quizlist.size() - 1)) {

                            i++;
                            startQuiz();

                        } else {

                            Intent intent = new Intent(Quiz.this, highScore.class);
                            startActivity(intent);


                        }


                    }
                }, 750);

            } else if (!answer.equals("nothing")) {

                textViewToChange.setVisibility(View.VISIBLE);
                textViewToChange.setText("Incorrect");
                textViewToChange.setTextColor(Color.parseColor("#0F0000"));
                textViewToChange.setBackgroundColor(Color.parseColor("#FF0000"));
                answerList.add(false);
                myAnswerList.add(answer);
                check = 1;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        String view = ("\nYou answered: \n" + answer + "\n\nThis was incorrect, the correct answer was:\n"
                                + quiz.getANSWER() + "\nPress Next Question again to continue.");
                        textViewToChange.setTextSize(25);
                        textViewToChange.setText(view);
                        textViewToChange.setVisibility(View.VISIBLE);
                        textViewToChange.setBackgroundColor(Color.parseColor("#CDCDCD"));
                        CheckBox Change = (CheckBox) findViewById(R.id.checkBox);
                        Change.setVisibility(View.INVISIBLE);
                        Change.setText("");
                        CheckBox Change2 = (CheckBox) findViewById(R.id.checkBox2);
                        Change2.setVisibility(View.INVISIBLE);
                        Change2.setText("");
                        CheckBox Change3 = (CheckBox) findViewById(R.id.checkBox3);
                        Change3.setVisibility(View.INVISIBLE);
                        Change3.setText("");
                        CheckBox Change4 = (CheckBox) findViewById(R.id.checkBox4);
                        Change4.setVisibility(View.INVISIBLE);
                        Change4.setText("");

                    }
                }, 750);


            } else if(check == 0 && answer.equals("nothing")){

                textViewToChange.setVisibility(View.VISIBLE);
                textViewToChange.setText("No Answer Submitted");
                textViewToChange.setTextColor(Color.parseColor("#0F0000"));
                textViewToChange.setBackgroundColor(Color.parseColor("#FF0000"));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        final TextView textViewToChange = (TextView) findViewById(R.id.textView2);
                        textViewToChange.setText("");
                        textViewToChange.setVisibility(View.INVISIBLE);

                        startQuiz();


                    }
                }, 750);

            }

        }
        else if (check == 1) {

            if (i < (quizlist.size() - 1)) {

                i++;
                startQuiz();
                textViewToChange.setText("");

                check = 0;

            }
            else if(i == (quizlist.size()-1)){

                Intent intent = new Intent(Quiz.this, highScore.class);
                startActivity(intent);

            }

        }
    }

    public String getAnswered(){

        String myAnswer = "";
        CheckBox ch;


        if(((CheckBox) findViewById(R.id.checkBox)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox);
            ch.setChecked(false);

        }
        else if(((CheckBox) findViewById(R.id.checkBox2)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox2);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox2);
            ch.setChecked(false);

        }
        else if(((CheckBox) findViewById(R.id.checkBox3)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox3);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox3);
            ch.setChecked(false);

        }
        else if(((CheckBox) findViewById(R.id.checkBox4)).isChecked()){

            final TextView textViewToChange5 = (TextView) findViewById(R.id.checkBox4);
            myAnswer = (String) textViewToChange5.getText();
            ch =(CheckBox) findViewById(R.id.checkBox4);
            ch.setChecked(false);

        }
        else{

            myAnswer = "nothing";

        }

        return myAnswer;

    }


        public void onCheckBox(View view) {
            // Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();

            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.checkBox:
                    if (checked) {

                        CheckBox ch3,ch2,ch4;
                        ch3 = (CheckBox) findViewById(R.id.checkBox3);
                        ch3.setSelected(false);
                        ch3.setChecked(false);
                        ch2 = (CheckBox) findViewById(R.id.checkBox2);
                        ch2.setSelected(false);
                        ch2.setChecked(false);
                        ch4 = (CheckBox) findViewById(R.id.checkBox4);
                        ch4.setSelected(false);
                        ch4.setChecked(false);
                    }

                    break;
                case R.id.checkBox2:
                    if (checked) {

                        CheckBox ch,ch3,ch4;
                        ch = (CheckBox) findViewById(R.id.checkBox);
                        ch.setSelected(false);
                        ch.setChecked(false);
                        ch3 = (CheckBox) findViewById(R.id.checkBox3);
                        ch3.setSelected(false);
                        ch3.setChecked(false);
                        ch4 = (CheckBox) findViewById(R.id.checkBox4);
                        ch4.setSelected(false);
                        ch4.setChecked(false);
                    }

                    break;
                case R.id.checkBox3:
                    if (checked) {
                        CheckBox ch,ch2,ch4;
                        ch = (CheckBox) findViewById(R.id.checkBox);
                        ch.setSelected(false);
                        ch.setChecked(false);
                        ch2 = (CheckBox) findViewById(R.id.checkBox2);
                        ch2.setSelected(false);
                        ch2.setChecked(false);
                        ch4 = (CheckBox) findViewById(R.id.checkBox4);
                        ch4.setSelected(false);
                        ch4.setChecked(false);
                    }


                    break;
                case R.id.checkBox4:
                    if (checked) {

                        CheckBox ch,ch2,ch3;
                        ch = (CheckBox) findViewById(R.id.checkBox);
                        ch.setSelected(false);
                        ch.setChecked(false);
                        ch2 = (CheckBox) findViewById(R.id.checkBox2);
                        ch2.setSelected(false);
                        ch2.setChecked(false);
                        ch3 = (CheckBox) findViewById(R.id.checkBox3);
                        ch3.setSelected(false);
                        ch3.setChecked(false);
                    }

                    break;

            }
        }


    }

